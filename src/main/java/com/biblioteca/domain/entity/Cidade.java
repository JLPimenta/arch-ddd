package com.biblioteca.domain.entity;

import com.biblioteca.domain.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade extends BaseEntity {
    @Id
    @Column(name = "ID_CIDADE", nullable = false, length = 36)
    private String id;

    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_UNIDADE_FEDERATIVA", foreignKey = @ForeignKey(name = "CIDADE_FK_01"), nullable = false)
    private UnidadeFederativa unidadeFederativa;

    @Column(name = "SITUACAO", nullable = false)
    private Boolean situacao;
}
