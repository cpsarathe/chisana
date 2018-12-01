package com.cp.chisana.validator;

import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cp.chisana.dto.UserDTO;

@Component("chUserValidator")
public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return clazz.equals(UserValidator.class);
    }

    public void validate(Object obj, Errors errors) {
        UserDTO userDTO = (UserDTO)obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.reg.email.required", new Object[]{userDTO},"user.reg.email.required");
        if(!GenericValidator.isEmail(userDTO.getEmail())){
            errors.rejectValue("email","user.reg.email.invalid", new Object[]{""}, "user.reg.email.invalid");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "user.reg.url.required", new Object[]{userDTO},"user.reg.url.required");
        if(!GenericValidator.isUrl(userDTO.getUrl())){
            errors.rejectValue("url","user.reg.url.invalid", new Object[]{""}, "user.reg.url.invalid");
        }
    }
}