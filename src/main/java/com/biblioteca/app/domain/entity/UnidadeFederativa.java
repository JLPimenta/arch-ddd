package com.biblioteca.app.domain.entity;

import com.biblioteca.app.domain.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "UNIDADE_FEDERATIVA")
public class UnidadeFederativa extends BaseEntity {

    @Id
    @Column(name = "ID_UNIDADE_FEDERATIVA", nullable = false)
    private String id;

    @Column(name = "SIGLA", nullable = false, length = 2, unique = true)
    private String sigla;

    @Column(name = "NOME", nullable = false, length = 36)
    private String nome;

    @Column(name = "SITUACAO", nullable = false)
    private Boolean situacao;
}