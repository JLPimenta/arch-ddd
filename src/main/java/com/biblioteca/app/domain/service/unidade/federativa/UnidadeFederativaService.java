package com.biblioteca.app.domain.service.unidade.federativa;

import com.biblioteca.app.domain.entity.unidade.federativa.UnidadeFederativa;
import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.repository.BaseRepository;
import com.biblioteca.app.domain.core.service.BaseService;
import com.biblioteca.app.domain.repository.unidade.federativa.UnidadeFederativaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadeFederativaService extends BaseService<UnidadeFederativa> implements IUnidadeFederativaService {

    protected UnidadeFederativaService(BaseRepository<UnidadeFederativa> repository) {
        super(repository);
    }

    @Override
    public UnidadeFederativa ativar(String id, Boolean ativo) throws DomainException {
        var unidadeFederativa = this.findById(id);
        unidadeFederativa.setSituacao(ativo);
        return getRepository().save(unidadeFederativa);
    }

    @Override
    public UnidadeFederativaRepository getRepository() {
        return (UnidadeFederativaRepository) super.getRepository();
    }
}
