package com.biblioteca.domain.core.exception;


import com.biblioteca.domain.core.message.Message;

public class ConstraintException extends DomainException {
    public ConstraintException() {
        super(Message.toLocale("error.constraint"));
    }
}
