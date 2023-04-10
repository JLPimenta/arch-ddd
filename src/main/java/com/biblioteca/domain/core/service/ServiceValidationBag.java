package com.biblioteca.domain.core.service;


import com.biblioteca.domain.core.controller.model.ValidationResponse;
import com.biblioteca.domain.core.exception.ValidationBagException;
import com.biblioteca.domain.core.service.validation.ICheckValidation;
import com.biblioteca.domain.core.service.validation.ValidationCheck;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por adicionar regras específicas ao campo
 */
@Service
@RequestScope
public class ServiceValidationBag implements IServiceValidationBag {

    private final List<ValidationResponse> validations;

    public ServiceValidationBag() {
        validations = new ArrayList<>();
    }

    @Override
    public void add(String field, String validation) {
        validations.add(new ValidationResponse(field, validation));
    }

    @Override
    public void validate() throws ValidationBagException {
        if (!validations.isEmpty()) {
            throw new ValidationBagException(validations);
        }
    }

    @Override
    public ICheckValidation check(String field) {
        return new ValidationCheck(field, this);
    }
}
