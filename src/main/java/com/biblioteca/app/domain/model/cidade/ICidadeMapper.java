package com.biblioteca.app.domain.model.cidade;

import com.biblioteca.app.domain.core.mapper.IBaseMapper;
import com.biblioteca.app.domain.entity.Cidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICidadeMapper extends IBaseMapper<Cidade, CidadeRequest, CidadeResponse> {
}
