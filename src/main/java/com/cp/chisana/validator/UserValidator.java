package com.cp.chisana.validator;

import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cp.chisana.dto.UserDTO;
import com.cp.chisana.utils.Utilities;

@Component("chUserValidator")
public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return clazz.equals(UserValidator.class);
    }

    public void validate(Object obj, Errors errors) {
        UserDTO userDTO = (UserDTO)obj;
        //validate email
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.reg.email.required", new Object[]{userDTO},"user.reg.email.required");
        if(!GenericValidator.isEmail(userDTO.getEmail())){
            errors.rejectValue("email","user.reg.email.invalid", new Object[]{""}, "user.reg.email.invalid");
        }
        //validate url
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "appDomainUrl", "user.reg.url.required", new Object[]{userDTO},"user.reg.url.required");
        if(!GenericValidator.isUrl(userDTO.getAppDomainUrl())){
            errors.rejectValue("appDomainUrl","user.reg.url.invalid", new Object[]{""}, "user.reg.url.invalid");
        }
        //validate appName
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "appName", "user.reg.app.name.required", new Object[]{userDTO},"user.reg.app.name.required");
        if(!org.apache.commons.lang3.StringUtils.isAlphanumeric(userDTO.getAppName())){
            errors.rejectValue("appName","user.reg.app.name.invalid", new Object[]{""}, "user.reg.app.name.invalid");
        }
    }
}