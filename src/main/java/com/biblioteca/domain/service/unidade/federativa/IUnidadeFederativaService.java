package com.biblioteca.domain.service.unidade.federativa;

import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.core.service.IBaseService;
import com.biblioteca.domain.entity.UnidadeFederativa;

public interface IUnidadeFederativaService extends IBaseService<UnidadeFederativa> {

    UnidadeFederativa ativar(String id, Boolean ativo) throws DomainException;
}
