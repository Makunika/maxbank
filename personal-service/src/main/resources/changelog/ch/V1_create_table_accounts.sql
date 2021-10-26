--liquibase formatted sql
--changeset maxim:1
CREATE TABLE accounts
(
    id          SERIAL      PRIMARY KEY,
    number      INTEGER     NOT NULL,
    type        VARCHAR(50) NOT NULL,
    balance     DECIMAL     NOT NULL DEFAULT 0,
    lock        BOOLEAN     NOT NULL DEFAULT FALSE,
    currency    VARCHAR(3)  NOT NULL
);
