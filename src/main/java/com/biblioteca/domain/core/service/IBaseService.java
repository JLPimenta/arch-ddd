package com.biblioteca.domain.core.service;

import com.biblioteca.domain.core.entity.BaseEntity;
import com.biblioteca.domain.core.exception.DomainException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.function.Function;

public interface IBaseService<T extends BaseEntity> {

    T create(T entity) throws DomainException;

    T update(String id, T entity) throws DomainException;

    void delete(String id) throws DomainException;

    void bind(T entity, T update);

    void validate(T entity) throws DomainException;

    <U> U create(T entity, Function<T, ? extends U> converter) throws DomainException;

    <U> U update(String id, T entity, Function<T, ? extends U> converter) throws DomainException;

    <U> U map(T entity, Function<T, ? extends U> converter);

    void existsById(final String id) throws DomainException;

    <U> Page<U> findAll(@Nullable Specification<T> spec, Pageable pageable, Function<T, ? extends U> converter);

    <U> List<U> findAll(@Nullable Specification<T> spec, Sort sort, Function<T, ? extends U> converter);

    <U> Page<U> findAll(Pageable pageable, Function<T, ? extends U> converter);

    <U> List<U> findAll(Sort sort, Function<T, ? extends U> converter);

    <U> U findById(String id, Function<T, ? extends U> converter) throws DomainException;

    Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);

    List<T> findAll(@Nullable Specification<T> spec, Sort sort);

    Page<T> findAll(Pageable pageable);

    List<T> findAll(Sort sort);

    T findById(String id) throws DomainException;


}
