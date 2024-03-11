CREATE TABLE user
(
    id         BINARY(16)   NOT NULL,
    created_at VARCHAR(255) NULL,
    created_by VARCHAR(255) NULL,
    updated_at VARCHAR(255) NULL,
    updated_by VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    name       VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    `role`     ENUM ('ROLE_USER', 'ROLE_ADMIN')    NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (id),
    UNIQUE (email)
);