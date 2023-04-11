package com.biblioteca.app.domain.entity;

import com.biblioteca.app.domain.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public class Pessoa extends BaseEntity {

    @Id
    @Column(name = "ID_PESSOA", length = 36, nullable = false)
    private String id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "TELEFONE", length = 11)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_PESSOA_01"))
    private Endereco endereco;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "SEXO", length = 20)
    private String sexo;

    @Column(name = "SITUACAO", nullable = false)
    private Boolean situacao;
}