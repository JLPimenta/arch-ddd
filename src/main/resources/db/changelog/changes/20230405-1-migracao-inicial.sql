CREATE TABLE revision
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_id       VARCHAR(150)                            NOT NULL,
    username      VARCHAR(150)                            NOT NULL,
    user_ip       VARCHAR(30),
    revision_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_revision PRIMARY KEY (id)
);