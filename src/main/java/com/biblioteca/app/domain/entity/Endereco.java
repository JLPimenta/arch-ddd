package com.biblioteca.app.domain.entity;

import com.biblioteca.app.domain.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "ENDERECO")
public class Endereco extends BaseEntity {

    @Id
    @Column(name = "ID_ENDERECO", nullable = false, length = 36)
    private String id;

    @Column(name = "LOGRADOURO", nullable = false, length = 120)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false, length = 10)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 120)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false, length = 120)
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CIDADE", foreignKey = @ForeignKey(name = "CIDADE_FK_01"), nullable = false)
    private Cidade cidade;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;

    @Column(name = "SITUACAO", nullable = false)
    private Boolean situacao;
}
