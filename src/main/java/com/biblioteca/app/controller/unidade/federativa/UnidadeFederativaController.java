package com.biblioteca.app.controller.unidade.federativa;

import com.biblioteca.app.domain.core.controller.BaseController;
import com.biblioteca.app.domain.core.entity.BaseEntityAtivarRequest;
import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.entity.UnidadeFederativa;
import com.biblioteca.app.domain.model.unidade.federativa.IUnidadeFederativaMapper;
import com.biblioteca.app.domain.model.unidade.federativa.UnidadeFederativaRequest;
import com.biblioteca.app.domain.model.unidade.federativa.UnidadeFederativaResponse;
import com.biblioteca.app.domain.service.unidade.federativa.IUnidadeFederativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/unidades-federativas")
@Tag(name = "Unidades Federativas")
public class UnidadeFederativaController extends BaseController<UnidadeFederativa, UnidadeFederativaRequest, UnidadeFederativaResponse> {

    protected UnidadeFederativaController(final IUnidadeFederativaService service, final IUnidadeFederativaMapper mapper) {
        super(service, mapper);
    }

    @Transactional
    @PatchMapping(path = "/ativar/{id}")
    @Operation(description = "Ativar ou desativar a Unidade Federativa")
    public UnidadeFederativaResponse ativar(@PathVariable("id") String id, @Valid @RequestBody BaseEntityAtivarRequest ativoRequest)
            throws DomainException {
        final var response = getService().ativar(id, ativoRequest.isAtivo());
        return getService().map(response, getMapper()::toResponse);
    }

    @Override
    public IUnidadeFederativaService getService() {
        return (IUnidadeFederativaService) super.getService();
    }

    @Override
    public IUnidadeFederativaMapper getMapper() {
        return (IUnidadeFederativaMapper) super.getMapper();
    }
}
