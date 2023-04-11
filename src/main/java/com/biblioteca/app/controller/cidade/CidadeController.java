package com.biblioteca.app.controller.cidade;


import com.biblioteca.app.domain.core.controller.BaseController;
import com.biblioteca.app.domain.core.entity.BaseEntityAtivarRequest;
import com.biblioteca.app.domain.core.exception.DomainException;
import com.biblioteca.app.domain.entity.Cidade;
import com.biblioteca.app.domain.model.cidade.CidadeRequest;
import com.biblioteca.app.domain.model.cidade.CidadeResponse;
import com.biblioteca.app.domain.model.cidade.ICidadeMapper;
import com.biblioteca.app.domain.service.cidade.ICidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
@Tag(name = "Cidades")
public class CidadeController extends BaseController<Cidade, CidadeRequest, CidadeResponse> {
    protected CidadeController(final ICidadeService service, final ICidadeMapper mapper) {
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
