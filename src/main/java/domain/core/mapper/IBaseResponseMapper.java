package domain.core.mapper;


import domain.core.entity.BaseEntity;

import java.util.List;

/**
 * Classe base de mapeamento de entidades
 *
 * @param <T> - Entidade.
 * @param <Q> - Classe de resposta.
 */
public interface IBaseResponseMapper<T extends BaseEntity, Q> {

    Q toResponse(T entity);

    List<Q> toListResponse(List<T> entityList);
}
