package com.biblioteca.app.domain.model.unidade.federativa;

import com.biblioteca.app.domain.shared.validation.RequiredSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeFederativaRequest {

    @RequiredSize(max = 120, label = "unidadeFederativa.nome")
    private String nome;
    @RequiredSize(max = 2, min = 2, label = "unidadeFederativa.sigla")
    private String sigla;
    @Builder.Default
    private Boolean situacao = Boolean.TRUE;

}
