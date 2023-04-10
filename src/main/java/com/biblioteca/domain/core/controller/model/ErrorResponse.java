package com.biblioteca.domain.core.controller.model;


import com.biblioteca.domain.core.exception.ValidationBagException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.biblioteca.domain.core.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private boolean validation;
    private String exception;
    private String stacktrace;
    private List<ValidationResponse> errors;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message, List<ValidationResponse> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.validation = errors != null && !errors.isEmpty();
    }

    public ErrorResponse(int status, String message, ValidationResponse error) {
        this.status = status;
        this.message = message;
        this.errors = Collections.singletonList(error);
        this.validation = error != null;
    }

    public static ErrorResponse notMappedException(Exception ex) {
        return ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(Message.toLocale("error.exception"))
                .exception(ex.getMessage())
                .stacktrace(ExceptionUtils.getStackTrace(ex))
                .validation(false)
                .build();
    }

    public static ErrorResponse badRequest(String message) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(message)
                .build();
    }

    public static ErrorResponse withoutAuthorization() {
        return ErrorResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(Message.toLocale("error.forbidden"))
                .build();
    }

    public static ErrorResponse withoutPermission() {
        return ErrorResponse.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(Message.toLocale("error.unauthorized"))
                .build();
    }

    public static ErrorResponse constraintException(Exception ex) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(Message.toLocale("error.constraint"))
                .exception(ex.getMessage())
                .stacktrace(ExceptionUtils.getStackTrace(ex))
                .validation(false)
                .build();

    }

    public static ErrorResponse entityDataException(Exception ex) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(Message.toLocale("error.entityData"))
                .exception(ex.getMessage())
                .stacktrace(ExceptionUtils.getStackTrace(ex))
                .validation(false)
                .build();
    }

    public static ErrorResponse validationBag(ValidationBagException ex) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(null)
                .validation(true)
                .errors(ex.getValidations())
                .build();
    }

    @JsonIgnore
    public List<String> getAllMessages() {
        var messages = new ArrayList<String>();

        if (errors != null) {
            this.errors.forEach(x -> messages.add(x.getMessage()));
        }

        if (message != null) {
            messages.add(message);
        }

        return messages;
    }
}
