package com.biblioteca.domain.core.exception;


import com.biblioteca.domain.core.controller.model.ValidationResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class ValidationBagException extends DomainException {

    private final transient List<ValidationResponse> validations;

    public ValidationBagException(final List<ValidationResponse> validations) {
        super(String.format("Validação Bag, total de %d itens", validations.size()));
        this.validations = validations;
    }
}
