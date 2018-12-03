package com.cp.chisana.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Properties;

/**
 * Created by Chandra.Sarathe on 11/18/2018.
 */
@Configuration
public class AppConfig {

    @Value("${chisana.email.user.name}")
    private String emailUserName;
    @Value("${chisana.email.user.password}")
    private String emailPassword;
    @Value("${chisana.email.encoding.utf8}")
    private String emailEncoding;
    @Value("${chisana.email.smtp.host}")
    private String emailSmtpHost;
    @Value("${chisana.email.smtp.port}")
    private int emailSmtpPort;
    @Value("${chisana.email.transport.protocol}")
    private String emailTransportProtocol;
    @Value("${chisana.email.smtp.auth}")
    private String emailSmtpAuth;
    @Value("${chisana.email.smtp.starttls.enable}")
    private String emailTlsEnable;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailSmtpHost);
        mailSender.setPort(emailSmtpPort);
        mailSender.setUsername(emailUserName);
        mailSender.setPassword(emailPassword);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailTransportProtocol);
        props.put("mail.smtp.auth", emailSmtpAuth);
        props.put("mail.smtp.starttls.enable", emailTlsEnable);

        return mailSender;
    }

}
