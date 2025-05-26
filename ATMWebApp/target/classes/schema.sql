-- schema.sql
CREATE TABLE IF NOT EXISTS user_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pin INT NOT NULL,
    balance DOUBLE NOT NULL
);
