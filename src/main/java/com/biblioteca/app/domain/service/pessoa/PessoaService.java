package com.biblioteca.app.domain.service.pessoa;

import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.message.Message;
import com.biblioteca.app.domain.core.service.BaseService;
import com.biblioteca.app.domain.entity.Pessoa;
import com.biblioteca.app.domain.repository.pessoa.PessoaRepository;
import com.biblioteca.app.domain.service.endereco.IEnderecoService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class PessoaService extends BaseService<Pessoa> implements IPessoaService {

    private final IEnderecoService enderecoService;

    protected PessoaService(final PessoaRepository repository, final IEnderecoService enderecoService) {
        super(repository);
        this.enderecoService = enderecoService;
    }

    @Override
    public void validate(Pessoa entity) throws DomainException {
        super.validate(entity);
        if (Boolean.FALSE.equals(existeCpf(entity.getCpf())) && Boolean.FALSE.equals(existeEmail(entity.getEmail()))) {
            if (Objects.nonNull(entity.getEndereco())) {
                enderecoService.validate(entity.getEndereco());
            }
        }
    }

    public void validate(Pessoa entity, String id) throws DomainException {
        super.validate(entity);
        this.existeCpf(entity.getCpf(), id);
        this.existeEmail(entity.getEmail(), id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Pessoa update(String id, Pessoa entity) throws DomainException {
        this.enderecoService.update(entity.getEndereco().getId(), entity.getEndereco());
        final Pessoa pessoa = getRepository().findById(id).orElseThrow(() -> new DomainException(Message.toLocale("error.notfound", id)));
        entity.setDataCriacao(pessoa.getDataCriacao());
        validate(entity, id);
        bind(pessoa, entity);

        return getRepository().save(pessoa);
    }

    @Override
    public Pessoa ativar(String pessoaId, boolean situacao) throws DomainException {
        var pessoa = this.findById(pessoaId);
        pessoa.setSituacao(situacao);

        return getRepository().save(pessoa);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Pessoa create(Pessoa entity) throws DomainException {
        validate(entity);
        return super.create(entity);
    }

    public Boolean existeCpf(String cpf) throws DomainException {
        if (getRepository().existsByCpf(cpf)) {
            throw new DomainException(Message.toLocale("error.cpf-existente"));
        }

        return getRepository().existsByCpf(cpf);
    }

    public void existeCpf(String cpf, String id) throws DomainException {
        Pessoa pessoa = getRepository().findById(id)
                .orElseThrow(() -> new DomainException(Message.toLocale("error.pessoa.nao.encontrada")));
        boolean valida = getRepository().existsByCpf(cpf) && ObjectUtils.notEqual(pessoa.getCpf(), cpf);

        if (BooleanUtils.isTrue(valida)) {
            throw new DomainException(Message.toLocale("error.cpf-existente"));
        }
    }

    @Override
    public Boolean existeEmail(String email) throws DomainException {
        if (getRepository().existsByEmail(email)) {
            throw new DomainException(Message.toLocale("error.email-existente"));
        }

        return getRepository().existsByEmail(email);
    }

    public void existeEmail(String email, String id) throws DomainException {
        Pessoa pessoa = getRepository().findById(id).orElseThrow(() -> new DomainException(Message.toLocale("error.pessoa.nao.encontrada")));
        boolean valida = getRepository().existsByEmail(email) && ObjectUtils.notEqual(pessoa.getEmail(), email);

        if (BooleanUtils.isTrue(valida)) {
            throw new DomainException(Message.toLocale("error.email-existente"));
        }
    }

    @Override
    public PessoaRepository getRepository() {
        return (PessoaRepository) super.getRepository();
    }

}
