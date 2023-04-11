package com.biblioteca.app.domain.core.controller;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.mapper.IBaseMapper;
import com.biblioteca.app.domain.core.service.IBaseService;
import com.biblioteca.app.domain.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller base que contém os métodos padrões de CRUD.
 *
 * @param <T> Entidade.
 * @param <R> Classe de requisição.
 * @param <Q> Classe de resposta.
 */
public abstract class BaseController<T extends BaseEntity, R, Q> {

    private final IBaseService<T> service;
    private final IBaseMapper<T, R, Q> mapper;

    protected BaseController(final IBaseService<T> service, final IBaseMapper<T, R, Q> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @PageableAsQueryParam
    @Operation(description = "Consulta os registros com paginação")
    public Page<Q> findPage(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.ASC)}) Pageable pageable) {
        return service.findAll(pageable, mapper::toResponse);
    }

    @GetMapping("/all")
    @Operation(description = "Consulta todos os registros sem paginação")
    public List<Q> findAll(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.ASC)}) Sort sort) {
        return service.findAll(sort, mapper::toResponse);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Consulta o registro pelo id")
    public Q findById(@PathVariable String id) throws DomainException {
        return service.findById(id, mapper::toResponse);
    }

    @PostMapping
    @Operation(description = "Cria um registro")
    public Q create(@Valid @RequestBody R entityRequest) throws DomainException {
        return service.create(mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Atualiza o registro")
    public Q update(@PathVariable("id") String id, @Valid @RequestBody R entityRequest)
            throws DomainException {
        return service.update(id, mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Deleta o registro por id")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws DomainException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    protected IBaseService<T> getService() {
        return service;
    }

    protected IBaseMapper<T, R, Q> getMapper() {
        return mapper;
    }

}
