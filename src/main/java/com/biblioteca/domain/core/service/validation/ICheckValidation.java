package com.biblioteca.domain.core.service.validation;

public interface ICheckValidation {
    ICheckValidation check(IValidationExpression expression, String message);
}
