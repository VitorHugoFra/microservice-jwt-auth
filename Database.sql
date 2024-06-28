CREATE DATABASE microservice;
CREATE USER vitor WITH PASSWORD 'vitor';
GRANT ALL PRIVILEGES ON DATABASE microservice TO vitor;

-- Conceda acesso ao banco de dados microservice
GRANT CONNECT ON DATABASE microservice TO vitor;

-- Conceda permissões para a tabela users
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO vitor;

-- Conceda permissões para as sequências associadas
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO vitor;


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO your_table_name (id, username, password, email) VALUES
(1, 'Vitor', 'password1', 'vitor@example.com'),
(2, 'Teste', 'TesteSenha', 'Teste2@example.com'),
(3, 'user3', 'password3', 'user3@example.com');

SELECT * FROM users WHERE username = 'Vitor' AND password = 'password1';
