package com.biblioteca.app.domain.service.cidade;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.service.IBaseService;
import com.biblioteca.app.domain.entity.Cidade;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICidadeService extends IBaseService<Cidade> {
    Cidade ativar(String id, Boolean ativo) throws DomainException;

    List<Cidade> findByUnidadeFederativa(String idUnidadeFederativa, Sort sort) throws DomainException;
}
