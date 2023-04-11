package com.biblioteca.app.domain.model.endereco;

import com.biblioteca.app.domain.model.cidade.CidadeResponse;
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
public class EnderecoResponse {

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private CidadeResponse cidade;

    private Boolean situacao;
}