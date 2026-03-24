# 💰 GastoAPI - Gestão Financeira

O **GastoAPI** é o motor de controle financeiro para sistemas multi-tenant focados em prestadores de serviços, como barbearias e guinchos. Ele permite o registro, organização por categorias padronizadas e gestão completa do fluxo de caixa.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**: Linguagem principal.
- **Spring Boot 3**: Framework para agilizar o desenvolvimento de APIs.
- **Spring Data JPA**: Para persistência e consultas ao banco de dados.
- **MySQL / H2**: Banco de dados relacional.
- **Maven**: Gerenciador de dependências.
- **Postman**: Testes e validação da API.

---

## 🏗️ Arquitetura do Projeto
O projeto segue o padrão de camadas para garantir manutenção e escalabilidade:

1. **Model**: Entidades e Enums (representação dos dados e regras).
2. **Repository**: Interface para comunicação com o banco (consultas personalizadas).
3. **Service**: Contém regras de negócio e validações.
4. **Controller**: Exposição dos endpoints REST para consumo externo.

---

## 🛠️ Funcionalidades
- [x] Cadastro de novos gastos com validação de valor positivo.
- [x] Listagem completa de todos os registros.
- [x] Busca filtrada por **Categoria** via URL.
- [x] Deleção de registros por ID com confirmação.
- [x] Padronização de categorias via `Enum` (Ex: `TRABALHO`, `CONTAS_FIXAS`).

---

## 📖 Como usar o projeto

### 1. Pré-requisitos
- Ter o Java 17 instalado.
- Ter o Maven configurado.
- (Opcional) Banco de Dados MySQL rodando ou usar o H2 (em memória).

### 2. Rodando a aplicação
No terminal, dentro da pasta do projeto:
```bash
mvn spring-boot:run
