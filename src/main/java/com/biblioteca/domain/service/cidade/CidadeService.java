package com.biblioteca.domain.service.cidade;

import com.biblioteca.domain.core.repository.BaseRepository;
import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.core.service.BaseService;
import com.biblioteca.domain.entity.Cidade;
import com.biblioteca.domain.repository.cidade.CidadeRepository;
import com.biblioteca.domain.service.unidade.federativa.IUnidadeFederativaService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService extends BaseService<Cidade> implements ICidadeService {

    private final IUnidadeFederativaService unidadeFederativaService;

    protected CidadeService(final BaseRepository<Cidade> repository, final IUnidadeFederativaService unidadeFederativaService) {
        super(repository);
        this.unidadeFederativaService = unidadeFederativaService;
    }

    @Override
    public void validate(Cidade entity) throws DomainException {
        unidadeFederativaService.existsById(entity.getUnidadeFederativa().getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Cidade create(Cidade entity) throws DomainException {
        validate(entity);
        return getRepository().save(entity);
    }

    @Override
    public Cidade ativar(String cidadeId, Boolean situacao) throws DomainException {
        var cidade = this.findById(cidadeId);
        cidade.setSituacao(situacao);
        return getRepository().save(cidade);
    }

    public List<Cidade> getCidadesByUnidadeFederativaId(String Id, Sort sort) {
        return getRepository().getByUnidadeFederativaId(Id, sort);
    }

    @Override
    public CidadeRepository getRepository() {
        return (CidadeRepository) super.getRepository();
    }

}
