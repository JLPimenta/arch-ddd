package com.biblioteca.app.domain.model.cidade;

import com.biblioteca.app.domain.core.entity.BaseEntityRequest;
import com.biblioteca.app.domain.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CidadeRequest {
    @Required
    private String nome;
    @Required
    private BaseEntityRequest unidadeFederativa;
    @Builder.Default
    private Boolean situacao = Boolean.TRUE;
}
