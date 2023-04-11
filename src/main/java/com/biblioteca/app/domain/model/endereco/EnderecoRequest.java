package com.biblioteca.app.domain.model.endereco;

import com.biblioteca.app.domain.core.entity.BaseEntityRequest;
import com.biblioteca.app.domain.shared.validation.RequiredSize;
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
public class EnderecoRequest {

        @RequiredSize(max = 120, label = "endereco.logradouro")
        private String logradouro;

        @RequiredSize(max = 10, label = "endereco.numero")
        private String numero;

        @RequiredSize(max = 120, label = "endereco.complemento", required = false)
        private String complemento;

        @RequiredSize(max = 120, label = "endereco.bairro")
        private String bairro;

        @RequiredSize(max = 8, label = "endereco.cep")
        private String cep;

        @RequiredSize(max = 36, label = "endereco.cidade")
        private BaseEntityRequest cidade;

        @Builder.Default
        private Boolean situacao = Boolean.TRUE;
}
