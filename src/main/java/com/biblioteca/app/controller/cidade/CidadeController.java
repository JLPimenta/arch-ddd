package com.biblioteca.app.controller.cidade;

import com.biblioteca.domain.core.controller.BaseController;
import com.biblioteca.domain.core.entity.BaseEntityAtivarRequest;
import com.biblioteca.domain.core.exception.DomainException;
import com.biblioteca.domain.entity.Cidade;
import com.biblioteca.domain.model.cidade.CidadeRequest;
import com.biblioteca.domain.model.cidade.CidadeResponse;
import com.biblioteca.domain.model.cidade.ICidadeMapper;
import com.biblioteca.domain.service.cidade.ICidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
@Tag(name = "Cidades")
public class CidadeController extends BaseController<Cidade, CidadeRequest, CidadeResponse> {

    protected CidadeController(final ICidadeService service, final ICidadeMapper mapper) {
        super(service, mapper);
    }

    @PatchMapping(path = "/ativar/{id}")
    @Operation(description = "Ativar ou desativar a Cidade")
    @Transactional
    public CidadeResponse ativar(@PathVariable("id") String id, @Valid @RequestBody BaseEntityAtivarRequest ativoRequest) throws DomainException {
        final var response = getService().ativar(id, ativoRequest.isAtivo());
        return getService().map(response, getMapper()::toResponse);
    }

    @GetMapping(path = "/unidade-federativa/{id}")
    @Operation(description = "Buscar Cidades por Unidade Federativa")
    public List<CidadeResponse> getCidadesByUnidadeFederativaId(@PathVariable("id") String id,
                                                                @SortDefault.SortDefaults({@SortDefault(sort = "denominacao", direction = Sort.Direction.ASC)}) Sort sort) {
        return getService().getCidadesByUnidadeFederativaId(id, sort).stream().map(getMapper()::toResponse).toList();
    }

    @Override
    public ICidadeService getService() {
        return (ICidadeService) super.getService();
    }

    @Override
    public ICidadeMapper getMapper() {
        return (ICidadeMapper) super.getMapper();
    }

}
