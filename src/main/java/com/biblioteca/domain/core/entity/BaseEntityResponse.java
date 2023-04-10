package com.biblioteca.domain.core.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityResponse {
    private String id;
    private String dataCriacao;
    private String dataAtualizacao;
}
