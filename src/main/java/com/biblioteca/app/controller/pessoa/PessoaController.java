package com.biblioteca.app.controller.pessoa;

import com.biblioteca.app.domain.core.controller.BaseController;
import com.biblioteca.app.domain.core.entity.BaseEntityAtivarRequest;
import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.entity.Pessoa;
import com.biblioteca.app.domain.model.pessoa.IPessoaMapper;
import com.biblioteca.app.domain.model.pessoa.PessoaRequest;
import com.biblioteca.app.domain.model.pessoa.PessoaResponse;
import com.biblioteca.app.domain.service.pessoa.IPessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoas")
public class PessoaController extends BaseController<Pessoa, PessoaRequest, PessoaResponse> {
    protected PessoaController(final IPessoaService service, IPessoaMapper mapper) {
        super(service, mapper);
    }

    @Transactional
    @PatchMapping(path = "/ativar/{id}")
    @Operation(description = "Ativar ou desativar uma pessoa")
    public PessoaResponse ativar(@PathVariable("id") String id, @Valid @RequestBody BaseEntityAtivarRequest ativarRequest) throws DomainException {
        final var response = getService().ativar(id, ativarRequest.isAtivo());
        return getService().map(response, getMapper()::toResponse);
    }

    @Override
    public IPessoaService getService() {
        return (IPessoaService) super.getService();
    }

    @Override
    public IPessoaMapper getMapper() {
        return (IPessoaMapper) super.getMapper();
    }
}