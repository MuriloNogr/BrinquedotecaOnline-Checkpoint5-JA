![Logo BrinquedotecaOnline](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/BrinquedoTeca.png)

Diagrama UML

![brinquedotecaUML](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/Brinquedoteca.jpg)

----------------------------------------

INTEGRANTES: 

550531 - Luis Fernando Menezes Zampar

551694 - Diogo Fagioli Bombonatti

89162 - Murilo Nogueira

550711 - Gabriel Galdino da Silva

------------------------------------------

Descrição do Projeto

A UML (Unified Modeling Language) da Brinquedoteca Online ilustra a interação entre os componentes do sistema, facilitando a compreensão da arquitetura e do fluxo de dados.

Componentes:

Controller:
BrinquedoController: Gerencia as requisições HTTP relacionadas aos brinquedos.
HomeController: Gerencia a página inicial da aplicação.
Service:
BrinquedoService: Implementa as regras de negócio para os brinquedos.
DTO:
BrinquedoDTO: Objeto que representa os dados de um brinquedo para transferência entre camadas.
Repository:
BrinquedoRepository: Interage com o banco de dados para persistir e recuperar os brinquedos.
Interações:

Listar todos os brinquedos:
O usuário envia uma requisição HTTP GET para o endpoint /brinquedos.
O BrinquedoController recebe a requisição e chama o BrinquedoService para listar todos os brinquedos.
O BrinquedoService consulta o BrinquedoRepository para recuperar a lista de brinquedos do banco de dados.
O BrinquedoRepository recupera a lista de brinquedos do banco de dados e a retorna para o BrinquedoService.
O BrinquedoService converte a lista de entidades Brinquedo em uma lista de objetos BrinquedoDTO para serem enviados ao controller.
O BrinquedoController retorna a lista de BrinquedoDTO para o usuário em formato JSON.

Encontrar um brinquedo por ID:
O usuário envia uma requisição HTTP GET para o endpoint /brinquedos/{id}, onde {id} é o ID do brinquedo que deseja consultar.
O BrinquedoController recebe a requisição e extrai o ID do brinquedo do parâmetro da URL.
O BrinquedoController chama o BrinquedoService para encontrar o brinquedo pelo ID.
O BrinquedoService consulta o BrinquedoRepository para recuperar o brinquedo do banco de dados pelo ID.
O BrinquedoRepository recupera o brinquedo do banco de dados pelo ID e o retorna para o BrinquedoService.
O BrinquedoService verifica se o brinquedo foi encontrado.
Se o brinquedo foi encontrado, o BrinquedoService o converte em um objeto BrinquedoDTO e o retorna para o controller.
Se o brinquedo não foi encontrado, o BrinquedoService retorna um código de erro HTTP 404 (Not Found).
O BrinquedoController retorna o BrinquedoDTO ou o código de erro HTTP 404 para o usuário em formato JSON.

Salvar um novo brinquedo:
O usuário envia uma requisição HTTP POST para o endpoint /brinquedos, acompanhado de um JSON contendo os dados do novo brinquedo.
O BrinquedoController recebe a requisição e extrai os dados do brinquedo do JSON.
O BrinquedoController converte os dados do JSON em um objeto BrinquedoDTO.
O BrinquedoController chama o BrinquedoService para salvar o novo brinquedo.
O BrinquedoService converte o objeto BrinquedoDTO em uma entidade Brinquedo.
O BrinquedoService chama o BrinquedoRepository para salvar a entidade Brinquedo no banco de dados.
O BrinquedoRepository salva a entidade Brinquedo no banco de dados e retorna o ID gerado para o BrinquedoService.
O BrinquedoService converte o ID gerado em um objeto BrinquedoDTO e o retorna para o controller.
O BrinquedoController retorna o BrinquedoDTO para o usuário em formato JSON.

Deletar um brinquedo:
O usuário envia uma requisição HTTP DELETE para o endpoint /brinquedos/{id}, onde {id} é o ID do brinquedo que deseja excluir.
O BrinquedoController recebe a requisição e extrai o ID do brinquedo do parâmetro da URL.
O BrinquedoController chama o BrinquedoService para deletar o brinquedo pelo ID.
O BrinquedoService chama o BrinquedoRepository para deletar o brinquedo do banco de dados pelo ID.
O BrinquedoRepository deleta o brinquedo do banco de dados.
O BrinquedoService retorna um código de sucesso HTTP 204 (No Content) para o controller.
O BrinquedoController retorna o código de sucesso HTTP 204 para o usuário.

Observações:

A UML não apresenta as interações com a interface gráfica do usuário, como cliques em botões ou navegação entre páginas.
A UML não detalha a implementação interna dos componentes, como métodos e atributos das classes.

Componentes Adicionais:

View:
BrinquedoListView: Exibe a lista de brinquedos para o usuário.
BrinquedoView: Exibe os detalhes de um brinquedo para o usuário.

Formulário:
BrinquedoForm: Permite ao usuário cadastrar um novo brinquedo.

Interações Adicionais:

Exibir a lista de brinquedos:
O usuário acessa a página inicial da aplicação.
O HomeController chama o BrinquedoService para listar todos os brinquedos.
O BrinquedoService segue os mesmos passos da interação "Listar todos os brinquedos".
O HomeController recebe a lista de BrinquedoDTO do BrinquedoService.
O HomeController envia a lista de BrinquedoDTO para a BrinquedoListView.
A BrinquedoListView renderiza a lista de brinquedos na tela do usuário.

Exibir os detalhes de um brinquedo:
O usuário clica em um brinquedo na lista de brinquedos.
A BrinquedoListView extrai o ID do brinquedo clicado e o envia para o BrinquedoController.
O BrinquedoController segue os mesmos passos da interação "Encontrar um brinquedo por ID".
O BrinquedoController recebe o BrinquedoDTO do BrinquedoService.
O BrinquedoController envia o BrinquedoDTO para a BrinquedoView.
A BrinquedoView renderiza os detalhes do brinquedo na tela do usuário.

Cadastrar um novo brinquedo:
O usuário acessa a página de cadastro de brinquedos.
O BrinquedoController cria um novo BrinquedoForm.
O BrinquedoController envia o BrinquedoForm para a view.
A view renderiza o BrinquedoForm na tela do usuário.
O usuário preenche o formulário com os dados do novo brinquedo.
O usuário envia o formulário preenchido para o BrinquedoController.
O BrinquedoController extrai os dados do formulário e os converte em um objeto BrinquedoDTO.
O BrinquedoController segue os mesmos passos da interação "Salvar um novo brinquedo".
O BrinquedoController recebe o BrinquedoDTO do BrinquedoService.
O BrinquedoController redireciona o usuário para a página de listagem de brinquedos.

Segue uma descrição direta e profissional dos artefatos definidos no arquivo pom.xml para documentação de projeto:

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


EndPoint Cadastrar

![Cadastrar](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/Cadastrar.png)


Endpoint listar

![Listar](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/Listar.png)


EndPoint home

![Home](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/Home.png)


http://localhost:8080/ (a porta que está definida como padrão dá acesso a home da aplicação)

http://localhost:8080/brinquedos/cadastrar (dá acesso a ferramenta de inserção de novos brinquedos na base de dados OracleSQL)

http://localhost:8080/brinquedos/listar (Busca e lista todos os brinquedos existentes na base de dados)

É importante lembrar que a UML é apenas uma ferramenta para modelar o sistema, e sua completude e detalhamento dependem do objetivo da modelagem.

TB_Brinquedos

![Banco](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/TB_Brinquedo.png)


![Spring initializr](https://github.com/MuriloNogr/CheckPoint2-JavaAdvanced/blob/main/springInitializr.png)

Versão: 3.2.5

