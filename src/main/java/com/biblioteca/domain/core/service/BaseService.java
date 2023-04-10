package com.biblioteca.domain.core.service;

import com.biblioteca.domain.core.entity.BaseEntity;
import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.core.message.Message;
import com.biblioteca.domain.core.repository.BaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

    private static final String ERROR_PROPERTY = "error.notfound";

    private final BaseRepository<T> repository;

    protected BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) throws DomainException {
        return repository.save(entity);
    }

    @Override
    public <U> U create(T entity, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(create(entity));
    }

    @Override
    public T update(String id, T entity) throws DomainException {
        T old = repository.findById(id).orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
        bind(old, entity);
        return repository.save(old);
    }

    @Override
    public <U> U update(String id, T entity, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(update(id, entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void bind(T entity, T update) {
        BeanUtils.copyProperties(update, entity, "id");
    }

    @Override
    public void validate(T entity) throws DomainException {
        // Necessario sobrescrever
    }

    @Override
    public <U> U map(T entity, Function<T, ? extends U> converter) {
        return converter.apply(entity);
    }

    @Override
    public void existsById(final String id) throws DomainException {
        if (!repository.existsById(id)) {
            throw new DomainException(Message.toLocale(ERROR_PROPERTY, id));
        }
    }

    @Override
    public <U> Page<U> findAll(@Nullable Specification<T> spec, Pageable pageable, Function<T, ? extends U> converter) {
        return findAll(spec, pageable).map(converter);
    }

    @Override
    public <U> List<U> findAll(@Nullable Specification<T> spec, Sort sort, Function<T, ? extends U> converter) {
        return repository.findAll(spec, sort).stream().map(converter).collect(Collectors.toList());
    }

    @Override
    public <U> Page<U> findAll(Pageable pageable, Function<T, ? extends U> converter) {
        return findAll(pageable).map(converter);
    }

    @Override
    public <U> List<U> findAll(Sort sort, Function<T, ? extends U> converter) {
        return findAll(sort).stream().map(converter).collect(Collectors.toList());
    }

    @Override
    public <U> U findById(String id, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(findById(id));
    }

    @Override
    public Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(@Nullable Specification<T> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public T findById(String id) throws DomainException {
        return repository.findById(id).orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
    }

    public BaseRepository<T> getRepository() {
        return this.repository;
    }
}
