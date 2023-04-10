package com.biblioteca.domain.model.cidade;

import com.biblioteca.domain.core.mapper.IBaseMapper;
import com.biblioteca.domain.entity.Cidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICidadeMapper extends IBaseMapper<Cidade, CidadeRequest, CidadeResponse> {
}
