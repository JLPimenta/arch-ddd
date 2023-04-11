package com.biblioteca.app.domain.model.pessoa;

import com.biblioteca.app.domain.model.endereco.EnderecoRequest;
import com.biblioteca.app.domain.shared.validation.RequiredSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaRequest {

    @RequiredSize(min = 3, max = 100, label = "pessoa.nome")
    private String nome;

    @CPF(message = "pessoa.cpf.invalido")
    @RequiredSize(min = 11, max = 11, label = "pessoa.cpf")
    private String cpf;

    @RequiredSize(max = 100, label = "pessoa.email")
    private String email;

    @RequiredSize(max = 11, label = "pessoa.telefone", required = false)
    private String telefone;

    @RequiredSize(label = "pessoa.endereco", required = false)
    private EnderecoRequest endereco;

    @RequiredSize(label = "pessoa.dataNascimento", required = false)
    private LocalDate dataNascimento;

    @RequiredSize(max = 20, label = "pessoa.sexo", required = false)
    private String sexo;

    @Builder.Default
    private Boolean situacao = Boolean.TRUE;
}
