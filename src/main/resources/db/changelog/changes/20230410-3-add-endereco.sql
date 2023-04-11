-- liquibase formatted sql
-- changeset JLPimenta:20230410-3-add-endereco

CREATE TABLE IF NOT EXISTS endereco
(
    id_endereco      VARCHAR(36)  NOT NULL,
    logradouro       VARCHAR(120) NOT NULL,
    numero           VARCHAR(10)  NOT NULL,
    complemento      VARCHAR(120),
    bairro           VARCHAR(120) NOT NULL,
    cep              VARCHAR(8)   NOT NULL,
    id_cidade        VARCHAR(63)  NOT NULL,
    situacao         BOOLEAN      NOT NULL,
    data_criacao     TIMESTAMP    NOT NULL,
    data_atualizacao TIMESTAMP,

    CONSTRAINT pk_endereco PRIMARY KEY (id_endereco),
    CONSTRAINT FK_ENDERECO_CIDADE FOREIGN KEY (id_cidade) REFERENCES cidade (id_cidade)
);