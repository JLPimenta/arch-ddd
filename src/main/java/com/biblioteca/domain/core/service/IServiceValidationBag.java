package com.biblioteca.domain.core.service;


import com.biblioteca.domain.core.exception.ValidationBagException;
import com.biblioteca.domain.core.service.validation.ICheckValidation;

public interface IServiceValidationBag {
    void add(String field, String validation) throws IllegalArgumentException;

    void validate() throws ValidationBagException;

    ICheckValidation check(String field);
}
