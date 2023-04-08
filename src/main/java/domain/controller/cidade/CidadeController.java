package domain.controller.cidade;

import domain.core.controller.BaseController;
import domain.core.entity.BaseEntityAtivarRequest;
import domain.core.exception.DomainException;
import domain.entity.Cidade;
import domain.model.cidade.CidadeRequest;
import domain.model.cidade.CidadeResponse;
import domain.model.cidade.ICidadeMapper;
import domain.service.cidade.CidadeService;
import domain.service.cidade.ICidadeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class CidadeController extends BaseController<Cidade, CidadeRequest, CidadeResponse> {
    protected CidadeController(final CidadeService service, final ICidadeMapper mapper) {
        super(service, mapper);
    }

    @PatchMapping("/ativar/{id}")
    @Transactional
    @Operation(summary = "Ativa ou desativa uma cidade")
    public CidadeResponse ativar(@PathVariable String id, @Valid @RequestBody BaseEntityAtivarRequest ativo) throws DomainException {
        final var response = getService().ativar(id, ativo.isAtivo());
        return getService().map(response, getMapper()::toResponse);
    }

    @GetMapping("/unidade-federativa/{id}")
    @Operation(summary = "Busca cidades por unidade federativa")
    public List<CidadeResponse> getCidadesByUnidadeFederativaId(@PathVariable String id,
                                                                @SortDefault.SortDefaults({@SortDefault(sort = "denominacao", direction = Sort.Direction.ASC)}) Sort sort) throws DomainException {
        return getService().findByUnidadeFederativa(id, sort).stream().map(getMapper()::toResponse).toList();
    }

    @Override
    public ICidadeService getService() {
        return (ICidadeService) super.getService();
    }
}
