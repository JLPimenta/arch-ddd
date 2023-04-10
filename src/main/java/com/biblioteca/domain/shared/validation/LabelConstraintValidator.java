package com.biblioteca.domain.shared.validation;

import com.biblioteca.domain.core.message.Message;

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
