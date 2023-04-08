package domain.service.unidade.federativa;

import domain.core.exception.DomainException;
import domain.core.repository.BaseRepository;
import domain.core.service.BaseService;
import domain.entity.unidade.federativa.UnidadeFederativa;
import domain.repository.unidade.federativa.UnidadeFederativaRepository;
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
