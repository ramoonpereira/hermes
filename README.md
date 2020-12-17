# Hermes
Java Rest API-  Communication Platform 

![image](https://amenteemaravilhosa.com.br/wp-content/uploads/2020/02/ilustracao-hermes.jpg)

[![CircleCI](https://circleci.com/gh/ramoonpereira/hermes.svg?style=shield)](https://circleci.com/gh/ramoonpereira/hermes)


## Requisitos - Dev - Para desenvolvimento
```sh
Java 15
Docker/Docker Compose
Plugin Lombok
Maven
MySql
IDE (IntelliJ)
```

## Requisitos - Runtime - Para execução do projeto
```sh
Docker/Docker Compose
```

## Variáveis de Ambiente
```sh
HERMES_ENV - Ambiente
HERMES_DATASOURCE_URL - URL JDBC 
HERMES_DATASOURCE_USERNAME - Usuário DB
HERMES_DATASOURCE_PASSWORD - Senha DB
HERMES_SECURITY_JWT_SECRET_KEY - Secret Key JWT Token
```

## Estrutura - Banco de dados
```sh
A aplicação fica responsável por executar o db.migrations gerando a database,tabelas e registros necessários.
```

## Execução do Projeto
```sh
Executar na raiz o comando 'docker-compose up -d'
Aplicação: disponível em porta 8080
DB: disponível em porta 3306
```

## Autenticação

**Obtendo um JWT Token para autenticar na API:**
```sh
https://jwt.io/
Gerar conforme secret - ENV - HERMES_SECURITY_JWT_SECRET_KEY
```

## WEB API

**Recursos disponiveis:**

| Rota | Versão |Descrição | HTTP Method | Autenticação |
| -- | -- | -- | -- | -- |
| /swagger-ui.html | v1 |Interface para documentação da API| GET | |
| /hermes/v1/communication | v1 | Método para inserir uma nova solicitação de comunicação | POST |  [:white_check_mark:] [JWT] |
| /hermes/v1/communication/{id} | v1 | Método para consultar uma solicitação de comunicação| GET |  [:white_check_mark:] [JWT] |
| /hermes/v1/communication/{id}| v1 | Método para remover uma solicitação de comunicação| DELETE |  [:white_check_mark:] [JWT] |


