package com.biblioteca.app.domain.service.endereco;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.message.Message;
import com.biblioteca.app.domain.core.service.BaseService;
import com.biblioteca.app.domain.entity.Endereco;
import com.biblioteca.app.domain.repository.endereco.EnderecoRepository;
import com.biblioteca.app.domain.service.cidade.ICidadeService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EnderecoService extends BaseService<Endereco> implements IEnderecoService {

    private final ICidadeService cidadeService;

    protected EnderecoService(final EnderecoRepository repository, final ICidadeService cidadeService) {
        super(repository);
        this.cidadeService = cidadeService;
    }

    @Override
    public void validate(Endereco entity) throws DomainException {
        if (Objects.nonNull(entity.getCidade())) {
            cidadeService.existsById(entity.getCidade().getId());
        }
    }

    @Override
    public Endereco update(String id, Endereco updateT) throws DomainException {
        final Endereco endereco = getRepository().findById(id).orElseThrow(() -> new DomainException(Message.toLocale("error.notfound", id)));
        validate(updateT);
        updateT.setDataCriacao(endereco.getDataCriacao());
        bind(endereco, updateT);
        return getRepository().save(endereco);
    }

    @Override
    public EnderecoRepository getRepository() {
        return (EnderecoRepository) super.getRepository();
    }
}
