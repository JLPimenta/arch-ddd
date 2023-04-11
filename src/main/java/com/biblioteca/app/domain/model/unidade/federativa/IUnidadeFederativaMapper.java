package com.biblioteca.app.domain.model.unidade.federativa;

import com.biblioteca.app.domain.core.mapper.IBaseMapper;
import com.biblioteca.app.domain.entity.UnidadeFederativa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUnidadeFederativaMapper extends IBaseMapper<UnidadeFederativa, UnidadeFederativaRequest, UnidadeFederativaResponse> {
}