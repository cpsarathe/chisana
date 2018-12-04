package com.cp.chisana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cp.chisana.dto.Email;
import com.cp.chisana.dto.ResponseDTO;
import com.cp.chisana.dto.UserDTO;
import com.cp.chisana.service.EmailService;
import com.cp.chisana.service.UserService;
import com.cp.chisana.utils.ApiHelper;
import com.cp.chisana.utils.ResponseEnum;
import com.cp.chisana.utils.Utilities;
import com.cp.chisana.utils.ValidationErrorBuilder;

import javax.annotation.Resource;

/**
 * User's in the project are those who wants to register their domain and
 * generate short url.
 * User will first register in system , get the token and pass subsequent token
 * along with domain for generating short url.
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ApiHelper apiHelper;

    @Resource(name="chUserValidator")
    private Validator validator;

    @Autowired
    private ValidationErrorBuilder validationErrorBuilder;

    @Resource(name="chUserService")
    private UserService userService;

    @Resource(name="chEmailService")
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;


    @Value("${chisana.email.verification.link}")
    private String emailVerificationLink;

    @PostMapping("/")
    @ResponseBody
    public ResponseDTO registerUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if(userDTO==null) {
            return apiHelper.getApiResponse(ResponseEnum.BAD_REQUEST_ERROR.getId(),Boolean.FALSE,"Invalid Request Data",userDTO);
        }
        //validate input

        //stripping domain name from url and overriding passed input
        String domainUrl = Utilities.stripDomainFromURL(userDTO.getAppDomainUrl());
        userDTO.setAppDomainUrl(domainUrl);

        validator.validate(userDTO, bindingResult);
        if(bindingResult.hasErrors()){
            return apiHelper.getApiResponse(ResponseEnum.VALIDATION_FAILURE.getId(), Boolean.FALSE, ResponseEnum.VALIDATION_FAILURE.getName(), validationErrorBuilder.writeValidationErrors(bindingResult));
        }
        userService.add(userDTO);

        prepareAndSendVerificationEmail(userDTO);

        return apiHelper.getApiResponse(ResponseEnum.SUCCESS.getId(),Boolean.TRUE,"User registered successfully",userDTO);
    }



    private void prepareAndSendVerificationEmail(UserDTO userDTO){
        Email email = new Email();
        email.setToEmail(userDTO.getEmail());
        email.setSubject("Chisana New User Registration Email Verification");
        Context thymeleafContext = new Context();
        thymeleafContext.setVariable("title","User Registration Email");
        String url = emailVerificationLink.replace("{0}", userDTO.getToken());
        thymeleafContext.setVariable("url",url);
        String htmlContent  = templateEngine.process("email-verification", thymeleafContext);
        email.setBody(htmlContent);
        emailService.sendSimpleMessage(email);

    }


}
