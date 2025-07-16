# 🌿 Sistema de Monitoramento de Plantas

Projeto acadêmico de uma aplicação web desenvolvida com **Java e Spring Boot** para o cadastro e visualização de plantas de jardinagem.

> **Status:** ✔️ Concluído

---

## 🎯 Objetivo

Este projeto foi criado para a disciplina de **Persistência Orientada a Objetos** e tem como objetivo aplicar os conceitos da arquitetura MVC (Model-View-Controller) para construir um sistema web funcional, capaz de realizar operações básicas de persistência de dados em um banco de dados relacional.

---

## ✨ Funcionalidades

- **Cadastro de Plantas:** Interface web para registrar novas plantas com informações como nome, localização, frequência de rega e estado de saúde.
- **Listagem de Plantas:** Exibição de todas as plantas cadastradas em uma tabela organizada.
- **Validação de Dados:** Uso de `Enums` para garantir a integridade de dados nos campos de seleção, como Localização (Interna/Externa) e Saúde da Planta, prevenindo a entrada de valores inválidos.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework Principal:** Spring Boot
- **Arquitetura:** Spring MVC
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL
- **Templates (Views):** Thymeleaf
- **Gerenciador de Dependências:** Maven

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar o projeto em um ambiente local.

### Pré-requisitos

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)

### Configuração

1.  **Clone o repositório:**
    ```bash
    git clone 
    ```

2.  **Crie o Banco de Dados:**
    - Acesse seu cliente MySQL e crie um banco de dados chamado `db_jardinagem`.
    - Execute o script SQL abaixo para criar a tabela `planta`:
    ```sql
    CREATE TABLE `planta` (
      `id` BIGINT NOT NULL AUTO_INCREMENT,
      `nome_planta` VARCHAR(255) NOT NULL,
      `localizacao` VARCHAR(50) NOT NULL,
      `frequencia_rega` VARCHAR(100) NOT NULL,
      `saude_planta` VARCHAR(100) NOT NULL,
      PRIMARY KEY (`id`)
    );
    ```

3.  **Configure a Conexão:**
    - Abra o arquivo `src/main/resources/application.properties`.
    - Altere as propriedades `spring.datasource.username` e `spring.datasource.password` com suas credenciais do MySQL.

### Executando a Aplicação

1.  **Via Terminal:**
    - Navegue até a pasta raiz do projeto.
    - Execute o comando:
    ```bash
    ./mvnw spring-boot:run
    ```

2.  **Via IDE (Eclipse/IntelliJ):**
    - Importe o projeto como um projeto Maven existente.
    - Encontre a classe `MonitoramentoApplication.java` (ou similar) e execute-a como uma Aplicação Java.

---

## 💻 Acesso

Com a aplicação rodando, acesse as seguintes URLs no seu navegador:

- **Página de Listagem:** `http://localhost:8081/plantas`
- **Página de Cadastro:** `http://localhost:8081/plantas/nova`

*(Nota: a porta utilizada foi a 8081, conforme configurado no arquivo `application.properties`)*

---

## ✒️ Autora

**Keren Hapuque**
