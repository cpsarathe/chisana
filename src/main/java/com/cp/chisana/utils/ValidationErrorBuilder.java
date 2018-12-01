package com.cp.chisana.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@Component("chValidationMessageBuilder")
public class ValidationErrorBuilder {

    @Autowired
    private MessageSource messageSource;

    public ValidationError writeValidationErrors(Errors errors) {
        ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.getErrors().add(messageSource.getMessage(objectError.getDefaultMessage(), new Object[]{""}, Locale.ENGLISH));
        }
        return error;
    }
}
