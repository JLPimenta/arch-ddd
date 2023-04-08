package domain.service.unidade.federativa;

import domain.core.exception.DomainException;
import domain.core.service.IBaseService;
import domain.entity.UnidadeFederativa;

public interface IUnidadeFederativaService extends IBaseService<UnidadeFederativa> {

    UnidadeFederativa ativar(String id, Boolean ativo) throws DomainException;
}
