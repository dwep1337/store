# Store API

Trabalho **Backend**, professora **Vanessa**.

API REST de uma mini loja com operações **CRUD** de produtos, desenvolvida em Java com Spring Boot e PostgreSQL.

## Objetivo

Implementar um backend simples para gerenciar produtos de uma loja, expondo endpoints HTTP para criar, listar, buscar, atualizar e remover registros, com validação de dados e persistência em banco relacional.

## Tecnologias

| Tecnologia         | Uso                                     |
| ------------------ | --------------------------------------- |
| Java 21            | Linguagem                               |
| Spring Boot 4      | Framework web e injeção de dependências |
| Spring Data JPA    | Persistência                            |
| PostgreSQL 16      | Banco de dados                          |
| Flyway             | Migrações e seed inicial                |
| Podman Compose     | Container do PostgreSQL                 |
| Lombok             | Redução de boilerplate                  |
| Jakarta Validation | Validação dos DTOs                      |

## Pré-requisitos

- Java 21
- Maven 3.9+ (ou use o wrapper `./mvnw`)
- Podman com `podman compose`

## Configuração

1. Clone o repositório e entre na pasta do projeto.

2. Copie o arquivo de ambiente:

```bash
cp .env.example .env
```

3. Ajuste as variáveis no `.env` (valores de exemplo):

```env
POSTGRES_HOST=localhost
POSTGRES_PORT=5432
POSTGRES_DB=store
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
```

4. Suba o PostgreSQL:

```bash
podman compose up -d
```

5. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

O Flyway cria a tabela `tb_products` e insere 10 produtos de exemplo na primeira execução.

## Endpoints

Base URL: `http://localhost:8080/products`

| Método   | Rota             | Descrição         | Status           |
| -------- | ---------------- | ----------------- | ---------------- |
| `POST`   | `/products`      | Criar produto     | `201 Created`    |
| `GET`    | `/products`      | Listar todos      | `200 OK`         |
| `GET`    | `/products/{id}` | Buscar por ID     | `200 OK`         |
| `PUT`    | `/products/{id}` | Atualizar produto | `200 OK`         |
| `DELETE` | `/products/{id}` | Remover produto   | `204 No Content` |

### Criar produto

**POST** `/products`

```json
{
  "name": "Mouse Gamer",
  "description": "Mouse com 6 botões programáveis",
  "price": 149.9
}
```

### Resposta (listar / buscar / atualizar)

```json
{
  "id": 1,
  "name": "Notebook Dell Inspiron 15",
  "description": "Notebook 15,6\" Intel Core i5, 8 GB RAM, SSD 256 GB",
  "price": 3499.9
}
```

### Regras de validação

| Campo         | Regra                                                             |
| ------------- | ----------------------------------------------------------------- |
| `name`        | Obrigatório, entre 3 e 100 caracteres                             |
| `description` | Obrigatório, até 255 caracteres                                   |
| `price`       | Obrigatório, maior que zero, até 10 dígitos inteiros e 2 decimais |

### Erros

**Validação** (`400 Bad Request`):

```json
{
  "message": "Erro de validação",
  "errors": {
    "name": "Nome deve ter entre 3 e 100 caracteres"
  }
}
```

**Produto não encontrado** (`404 Not Found`):

```json
{
  "message": "Produto não encontrado com id: 99"
}
```
