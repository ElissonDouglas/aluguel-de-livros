# 📖 Aluguel de Livros API

Uma API RESTful robusta desenvolvida com **Spring Boot** para gerenciar o fluxo completo de um sistema de locação de livros. O projeto engloba o cadastro e gerenciamento de usuários (clientes), catálogo de livros categorizados, o controle do status de empréstimos e o fluxo de pagamento associado.

---

## 🛠️ Tecnologias e Ferramentas

O projeto foi construído utilizando as seguintes tecnologias:

* **Linguagem Principal:** Java 25
* **Framework:** Spring Boot 4.1.0 (Snapshot)
* **Acesso a Dados / ORM:** Spring Data JPA / Hibernate
* **Banco de Dados:** - Banco em memória **H2** para o perfil de testes (`test`)
* Suporte nativo preparado para **PostgreSQL** em ambiente de produção


* **Gerenciador de Dependências:** Maven (com Maven Wrapper integrado)
* **Produtividade:** Lombok (redução de código boilerplate)
* **Formatação de Dados:** Jackson (manipulação e formatação JSON em conformidade com o padrão ISO 8601)

---

## 🏗️ Arquitetura do Projeto

A aplicação segue o padrão de arquitetura em camadas (Camadas de Serviço, Repositório e Controladores REST), garantindo a separação de responsabilidades e facilitando a manutenção e testes:

1. **Entities (Domínio):** Mapeamento objeto-relacional das tabelas de banco de dados, incluindo relacionamentos complexos como muitos-para-muitos (`Book` $\leftrightarrow$ `Category`) e relacionamentos com chaves compostas e tabelas intermediárias (`LoanItem` mapeando a associação detalhada entre livros e empréstimos).
2. **Repositories:** Interfaces que herdam as capacidades do `JpaRepository`, fornecendo operações completas de CRUD sem a necessidade de implementar código SQL manual.
3. **Services:** Camada responsável por abrigar as regras de negócio e validações da aplicação.
4. **Resources (Controllers):** Controladores REST que expõem os endpoints da API para o consumo externo.

---

## ✨ Funcionalidades Principais

### 👤 Gerenciamento de Usuários (Clientes)

* Cadastro, listagem, atualização de dados cadastrais e exclusão de clientes.
* Proteção contra loops de serialização recursiva na API (via `@JsonIgnore`) para manter as respostas limpas e performáticas.

### 📚 Catálogo de Livros e Categorias

* Organização flexível de livros com suporte a múltiplas categorias simultâneas (ex: um livro pode ser categorizado tanto em *Ficção* quanto em *Horror*).

### 🛒 Controle de Empréstimos e Itens

* Registro detalhado de empréstimos contendo informações sobre o momento da transação e status atual através de um Enum gerenciado (`REQUESTED`, `IN_POSSESSION`, `RETURNED`, `OVERDUE`).
* Suporte a múltiplos itens em um único empréstimo com cálculo automatizado de subtotal por item (Preço $\times$ Quantidade) e cálculo total consolidado do pedido.

### 💳 Fluxo de Pagamentos

* Associação um-para-um rígida controlando se o empréstimo já teve o seu respectivo pagamento efetuado e o instante em que ele ocorreu.

### ⚙️ Tratamento Global de Exceções

* Sistema centralizado de captura de erros (via `@ControllerAdvice`) que intercepta falhas comuns como recursos não encontrados (`ResourceNotFoundException`) e violações de integridade do banco de dados (`DatabaseException`), devolvendo respostas limpas e padronizadas ao cliente HTTP.

---

## 🗺️ Endpoints da API

Abaixo estão listados os principais recursos disponíveis para interação:

### Usuários (`/users`)

* `GET /users` - Retorna a lista de todos os usuários.
* `GET /users/{id}` - Busca um usuário específico pelo ID.
* `POST /users` - Cria um novo usuário.
* `PUT /users/{id}` - Atualiza os dados de um usuário existente.
* `DELETE /users/{id}` - Remove um usuário (caso não existam restrições de integridade).

### Empréstimos (`/loans`)

* `GET /loans` - Retorna a lista de todos os empréstimos cadastrados com seus respectivos totais e itens.
* `GET /loans/{id}` - Busca os detalhes consolidados de um empréstimo específico.

### Livros (`/books`)

* `GET /books` - Retorna todos os livros do catálogo.
* `GET /books/{id}` - Detalha as informações de um livro pelo ID.

### Categorias (`/categories`)

* `GET /categories` - Lista as categorias existentes.
* `GET /categories/{id}` - Busca uma categoria específica.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* Java JDK 25 instalado (ou superior).

### Instalação e Execução

1. Clone o repositório para o seu ambiente local.
2. Navegue até o diretório raiz do projeto.
3. O projeto utiliza o perfil de teste (`test`) por padrão no arquivo `application.properties`. Isso significa que o banco em memória H2 será populado automaticamente com dados de semente (`TestConfig.java`) ao iniciar.
4. Execute a aplicação utilizando o Maven Wrapper:

**No Linux/macOS:**

```bash
./mvnw spring-boot:run

```

**No Windows (Command Prompt/PowerShell):**

```powershell
./mvnw.cmd spring-boot:run

```

A API estará disponível e pronta para receber requisições no endereço: `http://localhost:8080`

### Acessando o Console H2 (Interface Gráfica do Banco de Dados)

Para inspecionar as tabelas criadas automaticamente (`tb_user`, `tb_book`, `tb_loan`, etc.) durante a execução no perfil de teste, acesse pelo navegador:

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User Name:** `sa`
* **Password:** *(deixe em branco)*
