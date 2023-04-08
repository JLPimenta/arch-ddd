package domain.model.unidade.federativa;

import domain.core.mapper.IBaseMapper;
import domain.entity.unidade.federativa.UnidadeFederativa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUnidadeFederativaMapper extends IBaseMapper<UnidadeFederativa, UnidadeFederativaRequest, UnidadeFederativaResponse> {
}
