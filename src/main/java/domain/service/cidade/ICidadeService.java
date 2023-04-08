package domain.service.cidade;

import domain.core.exception.DomainException;
import domain.core.service.IBaseService;
import domain.entity.Cidade;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICidadeService extends IBaseService<Cidade> {
    Cidade ativar(String id, Boolean ativo) throws DomainException;

    List<Cidade> findByUnidadeFederativa(String idUnidadeFederativa, Sort sort) throws DomainException;
}
