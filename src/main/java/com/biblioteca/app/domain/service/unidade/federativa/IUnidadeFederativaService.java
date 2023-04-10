package com.biblioteca.app.domain.service.unidade.federativa;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.service.IBaseService;
import com.biblioteca.app.domain.entity.unidade.federativa.UnidadeFederativa;

public interface IUnidadeFederativaService extends IBaseService<UnidadeFederativa> {

    UnidadeFederativa ativar(String id, Boolean ativo) throws DomainException;
}
