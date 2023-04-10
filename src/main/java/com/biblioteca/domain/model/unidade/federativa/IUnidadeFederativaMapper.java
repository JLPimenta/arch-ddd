package com.biblioteca.domain.model.unidade.federativa;

import com.biblioteca.domain.core.mapper.IBaseMapper;
import com.biblioteca.domain.entity.UnidadeFederativa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUnidadeFederativaMapper extends IBaseMapper<UnidadeFederativa, UnidadeFederativaRequest, UnidadeFederativaResponse> {
}
