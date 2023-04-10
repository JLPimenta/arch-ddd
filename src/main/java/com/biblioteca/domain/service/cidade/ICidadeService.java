package com.biblioteca.domain.service.cidade;

import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.core.service.IBaseService;
import com.biblioteca.domain.entity.Cidade;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICidadeService extends IBaseService<Cidade> {
    Cidade ativar(String cidadeId, Boolean situacao) throws DomainException;

    List<Cidade> getCidadesByUnidadeFederativaId(String Id, Sort sort);
}
