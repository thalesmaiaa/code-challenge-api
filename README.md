<h1 align="center">
  Code Challenge API
</h1>

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [PostgreSQL](https://www.postgresql.org/)

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/thalesmaiaa/code-challenge-api
```

- Executar a aplicação Spring Boot
- Acessar aplicação em `http://localhost:8000`.

## Arquitetura

![Desenho de Arquitetura](.github/Desenho%20de%20Arquitetura.png)

A arquitetura utilizada neste projeto é a MVC (Model-View-Controller), que separa a aplicação em três camadas principais:

Model: Representa a camada de dados, contendo as entidades e a lógica de acesso aos dados. No projeto, são definidas as classes de entidade (por exemplo, User) e a interface de repositório (UserRepository), que interagem com o banco de dados PostgreSQL.

View: Responsável pela interface com o usuário. Nesta API, a interação é via endpoints REST, não sendo implementada uma camada de visualização específica como páginas HTML. O Spring Boot lida com a serialização dos objetos de resposta para JSON.

Controller: Gerencia as requisições HTTP, manipulando as entradas dos usuários e retornando as respostas apropriadas. Os controladores (UserController) processam as solicitações, interagem com os serviços (UserService) para aplicar a lógica de negócio e retornam os dados processados aos clientes.

Service: Contém a lógica de negócio da aplicação. Os serviços (UserService) são responsáveis por processar os dados recebidos dos controladores, aplicar as regras de negócio e interagir com a camada de dados. Eles atuam como intermediários entre os controladores e os repositórios, garantindo uma separação clara de responsabilidades.

## API

- http :8000/users (POST, GET)
```
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Tue, 05 Mar 2024 19:07:52 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "name": string,
    "email": email@email.com,
    "departmentId": HR or FINANCE or IT | MARKETING,
}
```

- http :8000/users/{id} (GET, PUT, DELETE)
```
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Tue, 05 Mar 2024 19:08:13 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked
(PUT)
 {
    "name": string,
    "email": email@email.com,
    "departmentId": HR or FINANCE or IT | MARKETING,
}
```