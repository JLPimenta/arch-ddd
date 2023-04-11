package com.biblioteca.app.domain.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseEntity {

    @Column(name = "DATA_CRIACAO", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void prePersist() {
        if (this.getId() == null || this.getId().isBlank()) {
            this.setId(UUID.randomUUID().toString());
            this.dataCriacao = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    public abstract String getId();

    public abstract void setId(String id);
}