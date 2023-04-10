package com.biblioteca.app.controller.unidade.federativa;

import com.biblioteca.domain.core.controller.BaseController;
import com.biblioteca.domain.core.entity.BaseEntityAtivarRequest;
import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.entity.UnidadeFederativa;
import com.biblioteca.domain.model.unidade.federativa.UnidadeFederativaRequest;
import com.biblioteca.domain.model.unidade.federativa.UnidadeFederativaResponse;
import com.biblioteca.domain.model.unidade.federativa.IUnidadeFederativaMapper;
import com.biblioteca.domain.service.unidade.federativa.UnidadeFederativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/unidades-federativas")
@Tag(name = "Unidades Federativas")
public class UnidadeFederativaController extends BaseController<UnidadeFederativa, UnidadeFederativaRequest, UnidadeFederativaResponse> {

    protected UnidadeFederativaController(final UnidadeFederativaService service, final IUnidadeFederativaMapper mapper) {
        super(service, mapper);
    }

    @Transactional
    @PatchMapping(path = "/ativar/{id}")
    @Operation(description = "Ativar ou Inativar uma Unidade Federativa")
    public UnidadeFederativaResponse ativar(@PathVariable("id") String id, @Valid @RequestBody BaseEntityAtivarRequest request) throws DomainException {
        final var response = getService().ativar(id, request.isAtivo());
        return getService().map(response, getMapper()::toResponse);
    }

    @Override
    public UnidadeFederativaService getService() {
        return (UnidadeFederativaService) super.getService();
    }

    @Override
    public IUnidadeFederativaMapper getMapper() {
        return (IUnidadeFederativaMapper) super.getMapper();
    }
}
