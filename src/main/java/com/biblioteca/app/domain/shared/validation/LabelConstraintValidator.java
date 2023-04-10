package com.biblioteca.app.domain.shared.validation;

import com.biblioteca.app.domain.core.message.Message;

public class LabelConstraintValidator {
    protected String message(String messageCode) {
        if (messageCode.startsWith("{")) {
            return Message.toLocale(messageCode
                    .replace("{", "")
                    .replace("}", ""));
        }
        return messageCode;
    }
}
