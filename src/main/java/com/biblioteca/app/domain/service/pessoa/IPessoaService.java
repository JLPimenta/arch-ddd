package com.biblioteca.app.domain.service.pessoa;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.service.IBaseService;
import com.biblioteca.app.domain.entity.Pessoa;

public interface IPessoaService extends IBaseService<Pessoa> {

    Pessoa ativar(String pessoaId, boolean situacao) throws DomainException;

    Boolean existeEmail(String email) throws DomainException;
}
