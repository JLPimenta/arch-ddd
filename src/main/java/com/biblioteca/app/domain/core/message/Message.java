package com.biblioteca.app.domain.core.message;

import java.util.Locale;

public final class Message {

    private static MessageService messageService;

    private Message() {
    }

    public static void setMessageService(MessageService messageService) {
        Message.messageService = messageService;
    }

    public static String toLocale(String msgCode) {
        return messageService.toLocale(msgCode);
    }

    public static String toLocale(String msgCode, Object... args) {
        return messageService.toLocale(msgCode, args);
    }
    
    public static String toLocale(String msgCode, Locale locale, Object... args) {
        return messageService.toLocale(msgCode, locale, args);
    }
}
