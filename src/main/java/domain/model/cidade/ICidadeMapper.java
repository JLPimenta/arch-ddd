package domain.model.cidade;

import domain.core.mapper.IBaseMapper;
import domain.entity.Cidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICidadeMapper extends IBaseMapper<Cidade, CidadeRequest, CidadeResponse> {
}
