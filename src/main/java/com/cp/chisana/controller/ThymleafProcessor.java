package com.cp.chisana.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by Chandra.Sarathe on 12/4/2018.
 */
@Component
public class ThymleafProcessor {

    @Autowired
    private TemplateEngine templateEngine;


    public String getHtmlEmail(String templateName){
        return templateEngine.process(templateName,this.getContext());
    }

    public Context getContext() {
        Context thymeleafContext = new Context();
        return thymeleafContext;
    }
}
