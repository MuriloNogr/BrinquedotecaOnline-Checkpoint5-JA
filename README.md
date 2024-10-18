![Logo BrinquedotecaOnline](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/BrinquedoTeca.png)


------------------------------------------

# BrinquedoTecaOnline

Este projeto é uma aplicação web para o gerenciamento de brinquedos, desenvolvido em **Java** com **Spring Boot**. A aplicação utiliza **Spring Security** para controle de autenticação e autorização, além de **Thymeleaf** para renderização de páginas do frontend. O sistema oferece uma interface CRUD para o cadastro de brinquedos, com autenticação baseada em login, e foi implantado na plataforma **Fly.io**.

## Acessar a Aplicação

https://brinquedotecaonline-small-log-8264.fly.dev/api/index

## Visão Geral do Projeto

A aplicação permite que os usuários façam o gerenciamento de brinquedos, com as seguintes funcionalidades:

- Listagem de brinquedos
- Cadastro de novos brinquedos
- Atualização de brinquedos
- Exclusão de brinquedos

### Principais Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0**
- **Spring Security**: Para autenticação e autorização.
- **Thymeleaf**: Template engine para renderização do frontend.
- **Swagger**: Documentação interativa da API.
- **Fly.io**: Plataforma de deploy.
- **Docker**: Para conteinerização da aplicação.
- **Oracle Database**: Como banco de dados relacional.

## Estrutura do Projeto

O projeto segue o padrão de arquitetura **MVC (Model-View-Controller)** e utiliza a abordagem de camadas com separação de responsabilidades:

- **Controller**: Camada que gerencia os endpoints da aplicação.
- **Service**: Camada responsável pela lógica de negócios.
- **Repository**: Camada de persistência de dados.
- **Model**: Representação das entidades do banco de dados.

### Design Patterns

- **DTO (Data Transfer Object)**: Transferência de dados entre camadas.
- **Repository Pattern**: Abstração da lógica de acesso aos dados.
- **Service Layer**: Encapsulamento da lógica de negócios.

## Autenticação e Segurança

A aplicação utiliza **Spring Security** para implementar autenticação baseada em login. As seguintes funcionalidades de segurança estão configuradas:

- Páginas de login e logout personalizadas.
- Autorização de acesso às rotas do sistema: 
    - Acessos à rota `/api/brinquedos/**` exigem autenticação.
    - Acesso à rota `/api/index` é permitido sem autenticação.
- Proteção contra ataques **CSRF** está desabilitada no ambiente atual.
  
### Configuração do Spring Security

```java
http
    .csrf().disable()
    .authorizeHttpRequests()
    .requestMatchers("/api/brinquedos/**").authenticated()
    .requestMatchers("/api/index").permitAll()
    .anyRequest().permitAll()
    .and()
    .formLogin()
    .loginPage("/login")
    .defaultSuccessUrl("/api/brinquedos", true)
    .permitAll()
    .and()
    .logout()
    .logoutUrl("/logout")
    .logoutSuccessUrl("/login?logout")
    .permitAll();
```

## Documentação da API com Swagger

A aplicação utiliza o **Swagger** para a documentação interativa da API. Ele pode ser acessado no seguinte endpoint:

- `/swagger-ui.html`: Interface de usuário para testar as funcionalidades da API.

### Endpoints da API

Aqui estão os principais endpoints expostos pela API:

- **GET /api/brinquedos**: Lista todos os brinquedos cadastrados.
- **GET /api/brinquedos/{id}**: Retorna os detalhes de um brinquedo específico.
- **POST /api/brinquedos**: Cria um novo brinquedo.
- **PUT /api/brinquedos/edit/{id}**: Atualiza um brinquedo existente.
- **DELETE /api/brinquedos/delete/{id}**: Exclui um brinquedo.

### Exemplo de Requisição para Criar Brinquedo

```json
POST /api/brinquedos
{
  "NOME_BRINQUEDO": "Carrinho de Controle Remoto",
  "TIPO_BRINQUEDO": "Eletrônico",
  "CLASSIFICACAO_BRINQUEDO": "5+ anos",
  "TAMANHO_BRINQUEDO": "Médio",
  "PRECO_BRINQUEDO": "150.00",
  "URL_IMAGEM_BRINQUEDO": "http://exemplo.com/imagem.jpg"
}
```

## Frontend com Thymeleaf

A aplicação utiliza o **Thymeleaf** para renderizar o frontend. As páginas HTML dinâmicas estão localizadas na pasta `src/main/resources/templates`.

### Principais Páginas

- **login.html**: Página de login com formulário de autenticação.
- **brinquedos.html**: Página que exibe a lista de brinquedos.
- **brinquedo-form.html**: Formulário para criar e editar brinquedos.
- **index.html**: Página inicial da aplicação.

### Exemplo de Template com Thymeleaf

```html
<form th:action="${brinquedo.ID_BRINQUEDO} == null ? '/api/brinquedos' : '/api/brinquedos/edit/' + ${brinquedo.ID_BRINQUEDO}"
      th:object="${brinquedo}" method="post">
    <div>
        <label for="NOME_BRINQUEDO">Nome:</label>
        <input type="text" id="NOME_BRINQUEDO" th:field="*{NOME_BRINQUEDO}" required>
    </div>
    <button type="submit" th:text="${brinquedo.ID_BRINQUEDO} == null ? 'Adicionar' : 'Salvar'"></button>
</form>
```

## Deploy no Fly.io

O deploy da aplicação é feito na plataforma **Fly.io**. Para configurar o deploy, foi utilizado o arquivo `fly.toml` com as seguintes configurações principais:

```toml
app = 'brinquedotecaonline-small-log-8264'
primary_region = 'gig'

[http_service]
  internal_port = 8080
  force_https = true
```

### Dockerfile

A aplicação é conteinerizada utilizando **Docker**. O arquivo `Dockerfile` contém os seguintes passos:

1. Build da aplicação com Maven.
2. Criação da imagem final baseada na JDK 17.

```dockerfile
# Etapa 1: Compilar o projeto
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/BrinquedoTecaOnline-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## Diagrama UML

![CheckPoint5JaUml](https://github.com/user-attachments/assets/e64b5e03-908e-446e-8ef3-8aa62d117e65)

## Execução Local

Para rodar a aplicação localmente, siga as etapas:

1. Clone este repositório: `git clone <url-do-repositorio>`
2. Navegue até o diretório: `cd BrinquedoTecaOnline`
3. Compile o projeto e execute com Maven:
    ```bash
    mvn spring-boot:run
    ```

4. Acesse a aplicação no navegador em `http://localhost:8080`.

## Contribuidores

- **Luis Fernando Menezes Zampar** - RM 550531
- **Diogo Fagioli Bombonatti** - RM 551694
- **Murilo Nogueira** - RM 89162
- **Gabriel Galdino da Silva** - RM 550711
