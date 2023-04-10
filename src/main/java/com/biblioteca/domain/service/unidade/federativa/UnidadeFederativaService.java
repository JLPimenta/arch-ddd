package com.biblioteca.domain.service.unidade.federativa;

import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.core.repository.BaseRepository;
import com.biblioteca.domain.core.service.BaseService;
import com.biblioteca.domain.entity.UnidadeFederativa;
import com.biblioteca.domain.repository.unidade.federativa.UnidadeFederativaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadeFederativaService extends BaseService<UnidadeFederativa> implements IUnidadeFederativaService {

    protected UnidadeFederativaService(BaseRepository<UnidadeFederativa> repository) {
        super(repository);
    }

    @Override
    public UnidadeFederativa ativar(String id, Boolean ativo) throws DomainException {
        UnidadeFederativa unidadeFederativa = getRepository().findById(id).orElseThrow(() -> new DomainException("Unidade Federativa não encontrada"));
        unidadeFederativa.setSituacao(ativo);
        return getRepository().save(unidadeFederativa);
    }

    @Override
    public UnidadeFederativaRepository getRepository() {
        return (UnidadeFederativaRepository) super.getRepository();
    }
}
