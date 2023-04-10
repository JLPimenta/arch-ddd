package com.biblioteca.domain.core.service.validation;


import com.biblioteca.domain.core.service.IServiceValidationBag;

public record ValidationCheck(String field,
                              IServiceValidationBag validationBag) implements ICheckValidation {

    @Override
    public ICheckValidation check(IValidationExpression expression, String message) {
        if (expression.validate()) {
            validationBag.add(field, message);
        }
        return this;
    }
}
