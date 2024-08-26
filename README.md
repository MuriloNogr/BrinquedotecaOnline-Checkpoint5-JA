![Logo BrinquedotecaOnline](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/BrinquedoTeca.png)

Diagrama UML

![brinquedotecaUML](https://github.com/MuriloNogr/BrinquedotecaOnline/blob/main/brinquedotecaUML.png)

----------------------------------------

O **BrinquedoTecaOnline** foi implementado e o deploy da aplicação foi realizado utilizando o **Azure App Service**, uma plataforma oferecida pela Microsoft que permite o gerenciamento de aplicativos web de forma escalável e segura. Essa escolha proporcionou uma integração simples com o ecossistema do Azure, facilitando a configuração e o monitoramento contínuo da aplicação.

Ao utilizar o Azure App Service, foi possível automatizar grande parte do processo de deploy, integrando facilmente com o repositório de código, garantindo que novas atualizações possam ser aplicadas de maneira eficiente. Além disso, o Azure App Service oferece recursos como balanceamento de carga, escalabilidade automática e monitoramento detalhado, assegurando que a aplicação possa atender à demanda com alta disponibilidade e desempenho.

Link da API: https://brinquedoteca-f8hcceccawa8cwej.brazilsouth-01.azurewebsites.net/api/brinquedos

INTEGRANTES: 

550531 - Luis Fernando Menezes Zampar

551694 - Diogo Fagioli Bombonatti

89162 - Murilo Nogueira

550711 - Gabriel Galdino da Silva

------------------------------------------

Documentação do Código

O projeto BrinquedoTecaOnline é uma aplicação web desenvolvida em Spring Boot que tem como objetivo gerenciar um sistema de cadastro de brinquedos. A aplicação está dividida em várias camadas, cada uma desempenhando uma função específica dentro do sistema.

1. BrinquedoController
Descrição: É o controlador REST responsável por gerenciar as requisições HTTP para a API de brinquedos. Ele define os endpoints para listar, buscar por ID, criar, atualizar e deletar brinquedos.
Métodos:
getAllBrinquedos(): Retorna uma lista de todos os brinquedos.
getBrinquedoById(Long id): Retorna um brinquedo específico com base no ID.
createBrinquedo(BrinquedoDTO brinquedoDTO): Cria um novo brinquedo com base nos dados fornecidos.
updateBrinquedo(Long id, BrinquedoDTO brinquedoDTO): Atualiza um brinquedo existente com base no ID.
deleteBrinquedo(Long id): Deleta um brinquedo com base no ID.
2. BrinquedoDTO
Descrição: É o Data Transfer Object (DTO) que representa os dados do brinquedo que são transferidos entre as camadas da aplicação.
Atributos:
ID_BRINQUEDO: ID do brinquedo.
NOME_BRINQUEDO: Nome do brinquedo.
TIPO_BRINQUEDO: Tipo do brinquedo.
CLASSIFICACAO_BRINQUEDO: Classificação do brinquedo.
TAMANHO_BRINQUEDO: Tamanho do brinquedo.
PRECO_BRINQUEDO: Preço do brinquedo.
3. GlobalExceptionHandler
Descrição: Classe responsável por capturar e tratar exceções lançadas durante a execução das requisições. Retorna uma mensagem de erro personalizada em caso de exceções.
Métodos:
handleRuntimeException(RuntimeException e): Captura exceções do tipo RuntimeException e retorna uma mensagem de erro.
4. Brinquedo
Descrição: Entidade que representa a tabela TB_BRINQUEDOS no banco de dados. Contém as colunas e respectivas anotações que mapeiam para a estrutura do banco.
Atributos:
ID_BRINQUEDO: ID do brinquedo, gerado automaticamente.
NOME_BRINQUEDO: Nome do brinquedo.
TIPO_BRINQUEDO: Tipo do brinquedo.
CLASSIFICACAO_BRINQUEDO: Classificação do brinquedo.
TAMANHO_BRINQUEDO: Tamanho do brinquedo.
PRECO_BRINQUEDO: Preço do brinquedo.
5. BrinquedoRepository
Descrição: Interface que estende JpaRepository, fornecendo métodos para operações CRUD na entidade Brinquedo. O Spring Data JPA gera automaticamente a implementação desta interface.
Métodos:
Métodos padrão do JpaRepository para realizar operações como findAll, findById, save e delete.
6. BrinquedoService
Descrição: Serviço que contém a lógica de negócio para gerenciar os brinquedos. Converte entre as entidades Brinquedo e BrinquedoDTO, e utiliza o BrinquedoRepository para interagir com o banco de dados.
Métodos:
getAllBrinquedos(): Retorna todos os brinquedos convertidos para DTO.
getBrinquedoById(Long id): Retorna um brinquedo específico como DTO.
saveBrinquedo(BrinquedoDTO brinquedoDTO): Salva um novo brinquedo e o retorna como DTO.
updateBrinquedo(Long id, BrinquedoDTO brinquedoDTO): Atualiza um brinquedo existente e o retorna como DTO.
deleteBrinquedo(Long id): Deleta um brinquedo existente.
convertToDTO(Brinquedo brinquedo): Converte uma entidade Brinquedo para BrinquedoDTO.
convertToEntity(BrinquedoDTO dto): Converte um BrinquedoDTO para entidade Brinquedo.

Artefatos do Projeto
spring-boot-starter-data-jpa: Configura o Spring Data JPA para integração com bases de dados usando Hibernate como implementação JPA.
spring-boot-starter-data-rest: Permite a exposição automática de repositórios Spring Data como endpoints REST.
spring-boot-starter-jdbc: Provê suporte para acesso a dados JDBC, incluindo um pool de conexões.
spring-boot-starter-thymeleaf: Habilita a criação de aplicações Web MVC usando Thymeleaf como motor de templates.
spring-boot-starter-web: Oferece funcionalidades essenciais para o desenvolvimento de aplicações web, incluindo Spring MVC.
spring-boot-starter-web-services: Facilita a criação de serviços Web SOAP.
spring-boot-starter-webflux: Adiciona suporte para programação reativa na web com Spring WebFlux.
spring-boot-devtools: Ferramenta de desenvolvimento que proporciona reinício automático, reload de configurações e outras funcionalidades para desenvolvimento ágil.
spring-boot-starter-test: Inclui dependências para testar aplicações Spring Boot, utilizando JUnit, Spring Test & Spring Boot Test, AssertJ, Hamcrest, Mockito, JSONassert, e JsonPath.
reactor-test: Proporciona suporte para testes unitários em aplicações reativas que usam o Project Reactor.
jakarta.validation-api: Define a API de validação de beans, permitindo validações automáticas baseadas em anotações.
ojdbc8: Driver JDBC para conexão com bases de dados Oracle, compatível com Java 8.
Configuração de Build
spring-boot-maven-plugin: Plugin do Maven para gerenciar aplicações Spring Boot, suportando funcionalidades como a construção de artefatos executáveis e a execução de aplicações durante o desenvolvimento.

Observações Finais:

A UML agora apresenta uma visão mais completa das interações do sistema, incluindo as interações com a interface gráfica do usuário e o fluxo de dados entre os componentes.
A UML ainda não detalha a implementação interna dos componentes, mas fornece uma base sólida para a compreensão da arquitetura e do funcionamento do sistema.


Endpoints da API
GET /api/brinquedos

Descrição: Retorna uma lista com todos os brinquedos cadastrados no sistema.
Resposta: Uma lista de objetos BrinquedoDTO.
GET /api/brinquedos/{id}

Descrição: Retorna os detalhes de um brinquedo específico com base no ID fornecido.
Parâmetros:
id (Path Variable): ID do brinquedo a ser buscado.
Resposta: Um objeto BrinquedoDTO correspondente ao ID fornecido.
POST /api/brinquedos

Descrição: Cria um novo brinquedo no sistema com base nos dados fornecidos.
Corpo da Requisição: Um objeto BrinquedoDTO com os detalhes do novo brinquedo.
Resposta: O objeto BrinquedoDTO recém-criado, incluindo o ID gerado.
PUT /api/brinquedos/{id}

Descrição: Atualiza as informações de um brinquedo existente com base no ID fornecido.
Parâmetros:
id (Path Variable): ID do brinquedo a ser atualizado.
Corpo da Requisição: Um objeto BrinquedoDTO com os novos dados do brinquedo.
Resposta: O objeto BrinquedoDTO atualizado.
DELETE /api/brinquedos/{id}

Descrição: Remove um brinquedo do sistema com base no ID fornecido.
Parâmetros:
id (Path Variable): ID do brinquedo a ser deletado.
Resposta: Nenhuma (retorna um status HTTP indicando sucesso ou falha).
CORS
Cada um desses endpoints está configurado para aceitar requisições CORS (Cross-Origin Resource Sharing) originadas de http://localhost:8081, permitindo que o frontend, rodando nessa porta, possa acessar a API sem problemas de origem cruzada.

O projeto BrinquedoTecaOnline é configurado utilizando o Maven, e as dependências essenciais para seu funcionamento são gerenciadas através do arquivo pom.xml. A seguir, descrevo as principais dependências, suas funções, a versão do Java utilizada, e a versão do Spring Boot.

Versão do Java
Java 17: O projeto é configurado para ser compilado e executado utilizando a versão 17 do Java, que é uma das versões LTS (Long-Term Support), oferecendo novos recursos e melhorias de desempenho em relação a versões anteriores.
Versão do Spring Boot
Spring Boot 3.0.0: O projeto utiliza a versão 3.0.0 do Spring Boot. Esta versão oferece melhorias em termos de performance, segurança e suporte a novas tecnologias, além de simplificar o desenvolvimento de aplicações Java com convenções pré-configuradas.
Dependências
org.hibernate.validator
(8.0.0.Final)

Função: Fornece a validação de dados baseada em anotações, como @NotNull, @Size, entre outras, garantindo que os dados manipulados pelo sistema estejam de acordo com as regras de validação definidas.
org.glassfish
.el (4.0.1)

Função: Implementa a especificação Expression Language (EL), que é utilizada em várias tecnologias Java para dinamicamente acessar e manipular propriedades de objetos, principalmente em ambientes web.
jakarta.servlet
.servlet-api (5.0.0)

Função: Fornece a API de Servlet, que é essencial para a criação de aplicações web Java. A dependência está marcada com o escopo provided, indicando que ela é fornecida pelo contêiner de servlet (como o Tomcat) em tempo de execução.
org.springframework.boot

Função: Integra o Spring Data JPA ao projeto, facilitando a implementação de repositórios e o gerenciamento de entidades persistidas no banco de dados com base no JPA (Java Persistence API).
org.springframework.boot

Função: Adiciona suporte ao HATEOAS (Hypermedia as the Engine of Application State), que é um conceito RESTful para incluir links dinâmicos nas respostas HTTP, permitindo uma navegação fácil entre recursos relacionados.
org.springframework.boot

Função: Inclui as bibliotecas necessárias para a criação de aplicações web, como Spring MVC e Tomcat. Fornece suporte para criação de APIs RESTful e manipulação de requisições HTTP.
org.springframework.boot

Função: Oferece ferramentas de desenvolvimento que melhoram a experiência do desenvolvedor, como o reload automático de aplicações, simplificando o ciclo de desenvolvimento.
com.oracle.database.jdbc

Função: Fornece o driver JDBC para conectar a aplicação ao banco de dados Oracle, permitindo a execução de operações de persistência e recuperação de dados no banco.
org.projectlombok

Função: Simplifica o código Java ao gerar automaticamente código comum, como getters, setters, construtores e métodos equals e hashCode, através de anotações. A dependência está marcada como opcional, pois é usada apenas em tempo de desenvolvimento.
org.springframework.boot

Função: Inclui as bibliotecas necessárias para a realização de testes unitários e de integração, como JUnit, Mockito e Hamcrest, facilitando a criação de testes automatizados para a aplicação.
org.springdoc
(1.6.9)

Função: Integra o Spring Boot com a especificação OpenAPI, permitindo a geração automática de documentação interativa para a API REST através de uma interface web, facilitando a exploração e teste dos endpoints.
Plugin de Build
org.springframework.boot
Função: Facilita a execução e o empacotamento da aplicação Spring Boot através de comandos Maven, como mvn spring-boot:run para executar a aplicação e mvn package para empacotar a aplicação em um arquivo JAR executável. O plugin também inclui uma configuração para excluir a dependência do Lombok no build final, caso necessário.
Essas dependências e configurações fornecem a base para o desenvolvimento e execução da aplicação BrinquedoTecaOnline, garantindo que todas as funcionalidades essenciais sejam suportadas e que o desenvolvimento seja o mais eficiente possível.
