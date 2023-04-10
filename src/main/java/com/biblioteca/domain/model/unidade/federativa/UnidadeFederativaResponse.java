package com.biblioteca.domain.model.unidade.federativa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeFederativaResponse {
    private String id;
    private String nome;
    private String sigla;
    private Boolean situacao;
}
