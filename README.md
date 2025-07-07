# 📝 MemeHub - Sistema de Gerenciamento de Memes e Usuários

## 🌟 Visão Geral
Sistema composto por dois microsserviços Spring Boot:
1. **`meme-final`**: Gerencia memes e categorias (porta `8082`)
2. **`usuario-final`**: Gerencia usuários (porta `8081`)

Integração via Feign Client para validação de usuários.

## 🚀 Começando

### Pré-requisitos
- Java 17+
- Maven 3.6+
- Spring Boot 3.1+

### ▶ Como Executar

1. **Microsserviço de Usuários**:
```bash
cd usuario-final
./mvnw spring-boot:run  # Rodará em http://localhost:8081
```
2. **Microsserviço de Memes**:
```bash
cd meme-final
./mvnw spring-boot:run  # Rodará em http://localhost:8082
```

### 🛠 Tecnologias

- Java 17

- Spring Boot 3

- Spring Data JPA

- H2 Database (dev)

- Feign Client

- Lombok

- Maven

## 📡 Endpoints

### Microsserviço de Usuários (`usuario-final`)

| Método | Rota            | Descrição               |
|--------|-----------------|-------------------------|
| GET    | `/usuarios`     | Lista todos os usuários |
| POST   | `/usuarios`     | Cria um novo usuário    |
| GET    | `/usuarios/{id}`| Busca usuário por ID    |

### Microsserviço de Memes (`meme-final`)

| Método | Rota          | Descrição                                   |
|--------|---------------|---------------------------------------------|
| GET    | `/meme`       | Lista todos os memes                        |
| POST   | `/meme`       | Cria novo meme (valida usuário e categoria) |
| GET    | `/categoria`  | Lista todas as categorias                   |
| POST   | `/categoria`  | Cria nova categoria (valida usuário)        |

### 🏗 Estrutura do Projeto

- usuario-final

```bash
src/
├── main/
│   ├── java/
│   │   └── com/arturlogan/projetofinal/usuario_final/
│   │       ├── controllers/UsuarioController.java
│   │       ├── entities/Usuario.java
│   │       ├── repositories/UsuarioRepository.java
│   │       └── service/UsuarioService.java
│   └── resources/application.properties
```
- meme-final

```bash
src/
├── main/
│   ├── java/
│   │   └── com/arturlogan/projetofinal/meme_final/
│   │       ├── controllers/
│   │       │   ├── CategoriaMemeController.java
│   │       │   └── MemeController.java
│   │       ├── entities/
│   │       │   ├── CategoriaMeme.java
│   │       │   └── Meme.java
│   │       ├── feign/
│   │       │   ├── FeignClientUsuario.java
│   │       │   └── UsuarioFeign.java
│   │       ├── repositories/
│   │       ├── services/
│   │       │   ├── CategoriaMemeService.java
│   │       │   └── MemeService.java
│   │       └── MemeFinalApplication.java
│   └── resources/application.properties
```

### 🔄 Fluxo de Integração

## 1. Validação de Usuário:

  - Quando um meme/categoria é criado, o meme-final consulta o usuario-final via Feign
  - Endpoint: http://localhost:8081/usuarios/{id}
  - Se usuário não existir: retorna 400 Bad Request

## 2. Validação de Categoria

  - Meme só é criado se associado a categoria existente

### ⚙ Configuração do Banco de Dados

**Usuários:**
- URL: `http://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:db-usuariofinal`

**Memes:**
- URL: `http://localhost:8082/h2-console`
- JDBC URL: `jdbc:h2:mem:db-memefinal`

**Credenciais:**
- Usuário: `sa`
- Senha: (vazia)

## 📋 Regras de Negócio

### 👤 Microsserviço de Usuários

- **Criação de Usuários**:
  - O ID é gerado automaticamente via `UUID` se não for informado
  - Campos obrigatórios:
    - `nome` (string)
    - `email` (string, formato válido)
    - `data_cadastro` (date)

- **Consulta**:
  - Usuários inativos não aparecem nas listagens

### 🖼 Microsserviço de Memes

- **Validações**:
  - Todo meme deve ter:
    - `nome` (string)
    - `descricao` (string)
    - `dataCadastro` (date)
    - Associado a uma categoria existente
    - Vinculado a um usuário válido (verificado via Feign Client)

- **Categorias**:
  - Campos obrigatórios:
    - `nome` (string)
    - `descricao` (string)
    - `dataCadastro` (date)
    - `usuarioId` (string, deve existir no serviço de usuários)

- **Fluxo de Criação**:
  1. Valida existência do usuário
  2. Para memes: valida existência da categoria
  3. Persiste no banco de dados
 
- *Link do projeto original* : https://github.com/github-ebac/backend-java-pro/

 ## 🚀 Próximos Passos

- [ ] Adicionar autenticação JWT
- [ ] Implementar upload de imagens
- [ ] Adicionar testes unitários/integração
- [ ] Implementar documentação Swagger/OpenAPI
- [ ] Adicionar sistema de likes/comentários

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
