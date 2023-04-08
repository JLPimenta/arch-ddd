package domain.controller.unidade.federativa;

import domain.core.controller.BaseController;
import domain.core.entity.BaseEntityAtivarRequest;
import domain.core.exception.DomainException;
import domain.entity.UnidadeFederativa;
import domain.model.unidade.federativa.IUnidadeFederativaMapper;
import domain.model.unidade.federativa.UnidadeFederativaRequest;
import domain.model.unidade.federativa.UnidadeFederativaResponse;
import domain.service.unidade.federativa.UnidadeFederativaService;
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

    @PatchMapping(path = "/ativar/{id}")
    @Transactional
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
