package com.biblioteca.app.controller.endereco;

import com.biblioteca.app.domain.core.controller.BaseController;
import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.core.message.Message;
import com.biblioteca.app.domain.entity.Endereco;
import com.biblioteca.app.domain.model.endereco.EnderecoRequest;
import com.biblioteca.app.domain.model.endereco.EnderecoResponse;
import com.biblioteca.app.domain.model.endereco.IEnderecoMapper;
import com.biblioteca.app.domain.service.endereco.IEnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereços")
public class EnderecoController extends BaseController<Endereco, EnderecoRequest, EnderecoResponse> {

    protected EnderecoController(final IEnderecoService service, final IEnderecoMapper mapper) {
        super(service, mapper);
    }

    @Override
    public EnderecoResponse create(EnderecoRequest entityRequest) throws DomainException {
        throw new DomainException(Message.toLocale("metodoBloqueado"));
    }

    @Override
    public IEnderecoService getService() {
        return (IEnderecoService) super.getService();
    }

    @Override
    public IEnderecoMapper getMapper() {
        return (IEnderecoMapper) super.getMapper();
    }

}