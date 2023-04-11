package com.biblioteca.app.domain.model.endereco;

import com.biblioteca.app.domain.core.mapper.IBaseMapper;
import com.biblioteca.app.domain.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEnderecoMapper extends IBaseMapper<Endereco, EnderecoRequest, EnderecoResponse> {
}