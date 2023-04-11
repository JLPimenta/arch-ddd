package com.biblioteca.app.domain.model.cidade;

import com.biblioteca.app.domain.model.unidade.federativa.UnidadeFederativaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CidadeResponse {
    private String id;
    private String nome;
    private UnidadeFederativaResponse unidadeFederativa;
    private Boolean situacao;
}
