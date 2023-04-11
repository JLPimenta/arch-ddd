package com.biblioteca.app.domain.model.pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaResponse {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String sexo;

    private Boolean situacao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
