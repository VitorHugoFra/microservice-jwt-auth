# Microservice JWT Authentication

Este projeto é um exemplo de microserviço com autenticação JWT usando Java e Spring Boot. Ele demonstra como configurar a autenticação JWT para proteger endpoints de uma API RESTful.

## Requisitos

- Java 11 ou superior
- Maven
- PostgreSQLClaro, vou criar um arquivo README detalhado para o seu projeto de microserviço JWT. Vou assumir que o projeto usa Java com Spring Boot e que ele possui autenticação JWT.

### README.md

```markdown
# Microservice JWT Authentication

Este projeto é um exemplo de microserviço com autenticação JWT usando Java e Spring Boot. Ele demonstra como configurar a autenticação JWT para proteger endpoints de uma API RESTful.

## Requisitos

- Java 11 ou superior
- Maven
- PostgreSQL

## Configuração

### Banco de Dados

1. **Instale o PostgreSQL**: 
   - [Instruções de Instalação do PostgreSQL](https://www.postgresql.org/download/)

2. **Crie o Banco de Dados**:
   ```sql
   CREATE DATABASE microservice;
   CREATE USER vitor WITH ENCRYPTED PASSWORD 'your_password';
   GRANT ALL PRIVILEGES ON DATABASE microservice TO vitor;
   ```

3. **Conceda Permissões ao Usuário**:
   ```sql
   \c microservice
   GRANT CONNECT ON DATABASE microservice TO vitor;
   GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO vitor;
   GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO vitor;
   ```

### Aplicação

1. **Clone o Repositório**:
   ```sh
   git clone https://github.com/seu-usuario/microservice-jwt-auth.git
   cd microservice-jwt-auth
   ```

2. **Configure o Application Properties**:
   Edite o arquivo `src/main/resources/application.properties` com as configurações do seu banco de dados:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/microservice
   spring.datasource.username=vitor
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

   jwt.secret=your_secret_key
   ```

3. **Compile e Execute a Aplicação**:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints

### Autenticação

**Login**: 
```sh
POST /auth/login
Content-Type: application/json

{
    "username": "Vitor",
    "password": "password1"
}
```

Resposta:
```json
{
    "token": {
        "chars": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXRvciIsImlhdCI6MTcxOTU5NDUwNiwiZXhwIjoxNzE5NjgwOTA2fQ.FHgPNDQzDLejRDN6e0zkUQDiWKuQCcGyThGnSyAlm6I",
        "string": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXRvciIsImlhdCI6MTcxOTU5NDUwNiwiZXhwIjoxNzE5NjgwOTA2fQ.FHgPNDQzDLejRDN6e0zkUQDiWKuQCcGyThGnSyAlm6I",
        "valueType": "STRING"
    }
}
```

### Endpoints Protegidos

**Exemplo de Endpoint Protegido**:
```sh
GET /protected-endpoint
Authorization: Bearer <your_jwt_token>
```

Resposta:
```json
"This is a protected endpoint"
```

## Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           ├── MicroserviceJwtAuthApplication.java
│   │           ├── config
│   │           │   └── SecurityConfig.java
│   │           ├── controller
│   │           │   └── ProtectedEndpointController.java
│   │           ├── filter
│   │           │   └── JWTFilter.java
│   │           ├── model
│   │           │   └── User.java
│   │           ├── repository
│   │           │   └── UserRepository.java
│   │           └── service
│   │               └── UserService.java
│   └── resources
│       ├── application.properties
│       └── schema.sql
└── test
    └── java
        └── com
            └── example
                └── MicroserviceJwtAuthApplicationTests.java
```

## Notas Adicionais

- **Segurança**: Mantenha a chave secreta JWT (`jwt.secret`) segura e não a compartilhe publicamente.
- **Expiração do Token**: Implemente lógica para renovar tokens JWT conforme necessário.
- **Logs**: Verifique os logs do servidor para monitorar o status da aplicação e diagnosticar problemas.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
```

Esse README fornece uma visão geral do projeto, incluindo os passos de configuração, execução, e uso dos endpoints. Ele também descreve a estrutura do projeto e oferece algumas notas adicionais sobre segurança e contribuição.