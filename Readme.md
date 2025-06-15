# AccessGate 🚪

Sistema de **Controle de Acesso** para ambientes físicos e digitais. Permite o gerenciamento de pessoas, equipamentos e registros de acesso.

## 📋 Descrição

O **AccessGate** é uma API desenvolvida com foco em segurança e controle de acesso. Ele permite o cadastro de pessoas, equipamentos e o gerenciamento de permissões e registros de entrada/saída.

---

## ✅ Funcionalidades

### 📌 Módulo: Pessoas
- [ ] Cadastro de pessoas
- [ ] Atualização de dados de pessoas
- [ ] Consulta de pessoas por ID, nome ou documento
- [ ] Exclusão lógica de pessoas
- [ ] Listagem paginada de pessoas

### 📌 Módulo: Equipamentos
- [ ] Cadastro de equipamentos (ex: portas, catracas, dispositivos de leitura)
- [ ] Atualização de equipamentos
- [ ] Consulta de equipamentos por ID ou nome
- [ ] Exclusão lógica de equipamentos
- [ ] Listagem paginada de equipamentos

### 📌 Módulo: Permissões de Acesso
- [ ] Definir quais pessoas têm acesso a quais equipamentos
- [ ] Atualização de permissões
- [ ] Consulta de permissões de uma pessoa
- [ ] Exclusão de permissões

### 📌 Módulo: Registros de Acesso
- [ ] Registro de tentativa de acesso (permitido ou negado)
- [ ] Consulta de registros de acesso por pessoa, equipamento ou data
- [ ] Exportação de registros (CSV/JSON)
- [ ] Filtro por status (Acesso Permitido / Negado)

### 📌 Módulo: Autenticação e Segurança
- [ ] Implementação de autenticação JWT
- [ ] Controle de roles (ex: Admin, Operador)
- [ ] Logs de atividades

### 📌 Outras Funcionalidades Técnicas
- [ ] Documentação da API com Swagger/OpenAPI
- [ ] Validações de entrada (Bean Validation)
- [ ] Testes unitários
- [ ] Testes de integração
- [ ] Configuração de Profiles (dev, prod)
- [ ] Tratamento global de erros (Exception Handler)

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Swagger / OpenAPI**

---

## 🚀 Como rodar o projeto

```bash
# Clone o repositório
git clone https://github.com/1pedrohfreitas/access_gate
cd accessgate
crie o arquivo .env para conter as variáveis de ambiente necessárias com base no arquivo .env.example

Crie o banco de dados PostgreSQL
execute o script de criação do banco de dados

# Configure as variáveis de ambiente (ex: application.properties)

# Rode a aplicação
./mvnw spring-boot:run
