package domain.service.cidade;

import domain.core.exception.DomainException;
import domain.core.repository.BaseRepository;
import domain.core.service.BaseService;
import domain.entity.Cidade;
import domain.repository.cidade.CidadeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService extends BaseService<Cidade> implements ICidadeService {

    protected CidadeService(BaseRepository<Cidade> repository) {
        super(repository);
    }


    public Cidade ativar(String id, Boolean ativo) throws DomainException {
        Cidade cidade = getRepository().findById(id).orElseThrow(() -> new DomainException("Cidade não encontrada"));
        cidade.setSituacao(ativo);
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
