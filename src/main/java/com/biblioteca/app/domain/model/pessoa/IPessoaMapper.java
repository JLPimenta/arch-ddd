package com.biblioteca.app.domain.model.pessoa;

import com.biblioteca.app.domain.core.mapper.IBaseMapper;
import com.biblioteca.app.domain.entity.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPessoaMapper extends IBaseMapper<Pessoa, PessoaRequest, PessoaResponse> {
}