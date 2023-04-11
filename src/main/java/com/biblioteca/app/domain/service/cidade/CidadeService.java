package com.biblioteca.app.domain.service.cidade;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.service.BaseService;
import com.biblioteca.app.domain.entity.Cidade;
import com.biblioteca.app.domain.repository.cidade.CidadeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService extends BaseService<Cidade> implements ICidadeService {

    protected CidadeService(final CidadeRepository repository) {
        super(repository);
    }

    @Override
    public Cidade ativar(String cidadeId, Boolean situacao) throws DomainException {
        var cidade = this.findById(cidadeId);
        cidade.setSituacao(situacao);
        return getRepository().save(cidade);
    }

    public List<Cidade> findByUnidadeFederativa(String idUnidadeFederativa, Sort sort) throws DomainException {
        try {
            return getRepository().getByUnidadeFederativaId(idUnidadeFederativa, sort);
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }

    @Override
    public CidadeRepository getRepository() {
        return (CidadeRepository) super.getRepository();
    }
}
