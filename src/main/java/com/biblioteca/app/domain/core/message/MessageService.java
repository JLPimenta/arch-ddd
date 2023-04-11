package com.biblioteca.app.domain.core.message;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageService {

    private final ResourceBundleMessageSource messageSource;

    public MessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
        Message.setMessageService(this);
    }

    public String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, locale);
    }

    public String toLocale(String msgCode, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, args, locale);
    }
    
    public String toLocale(String msgCode, Locale locale, Object... args) {
        return messageSource.getMessage(msgCode, args, locale);
    }

}
