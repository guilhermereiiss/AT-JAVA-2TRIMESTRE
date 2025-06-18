AT-JAVA-2TRI-OFC
Visão Geral
Este projeto é uma API RESTful desenvolvida em Java para gerenciamento de tarefas, criada como parte de um trabalho acadêmico. Utiliza o Javalin como framework web para lidar com requisições e respostas HTTP, com foco em criar, recuperar e listar tarefas. O projeto inclui um cliente para interagir com a API, uma camada de armazenamento para gerenciamento de tarefas e testes unitários para garantir a funcionalidade. É construído usando Gradle para gerenciamento de dependências e automação do projeto.
Estrutura do Projeto
O projeto segue a estrutura padrão de um projeto Java/Gradle:
AT-JAVA-2TRI-OFC/
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               ├── api/
│   │               │   ├── ApiClient.java
│   │               │   └── TaskApi.java
│   │               ├── client/
│   │               │   ├── HttpClientUtil.java
│   │               │   ├── StatusClient.java
│   │               │   ├── TaskByIdClient.java
│   │               │   ├── TaskClient.java
│   │               │   └── TaskListClient.java
│   │               ├── config/
│   │               │   ├── ApiResponse.java
│   │               │   └── StatusInfo.java
│   │               ├── dto/
│   │               │   └── TaskDTO.java
│   │               ├── storage/
│   │               │   └── TaskStorage.java
│   │               ├── Application.java
│   │               └── Main.java
│   ├── test/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── api/
│   │                   └── TaskApiTest.java
├── .gitignore
├── build.gradle.kts
├── gradlew
├── gradlew.bat
└── settings.gradle.kts

Componentes Principais

api/: Contém a lógica principal da API.
ApiClient.java: Cliente para interagir com os endpoints da API (criar, listar e buscar tarefas por ID).
TaskApi.java: Define as rotas da API usando o Javalin para lidar com requisições HTTP.


client/: Classes utilitárias para realizar requisições HTTP à API.
HttpClientUtil.java: Gerencia requisições HTTP GET e POST.
StatusClient.java, TaskByIdClient.java, TaskClient.java, TaskListClient.java: Clientes especializados para interações específicas com a API.


config/: Modelos de dados para respostas da API.
ApiResponse.java: Representa detalhes de respostas HTTP (código de status e conteúdo).
StatusInfo.java: Armazena informações de status com um timestamp.


dto/: Objeto de Transferência de Dados para tarefas.
TaskDTO.java: Representa uma tarefa com campos como ID, título, descrição, status de conclusão e data de criação.


storage/: Armazenamento em memória para tarefas.
TaskStorage.java: Gerencia o armazenamento e recuperação de tarefas.


Application.java: Ponto de entrada para iniciar o servidor Javalin.
Main.java: Classe principal vazia (placeholder para futuras extensões).
test/: Contém testes unitários para a API.
TaskApiTest.java: Testa os principais endpoints da API usando ferramentas de teste do Javalin e JUnit.



Tecnologias Utilizadas

Java: Linguagem de programação principal.
Javalin (6.6.0): Framework web leve para criar APIs RESTful.
Jackson (2.15.0): Para serialização e desserialização de JSON.
SLF4J (2.0.9): Framework de logging.
JUnit Jupiter (5.10.0): Para testes unitários.
Gradle (8.10): Ferramenta de automação de build.
JavaTimeModule: Para lidar com LocalDateTime em JSON.

Pré-requisitos

Java 11+: Certifique-se de que o Java está instalado e a variável JAVA_HOME está configurada.
Gradle: O projeto inclui um wrapper Gradle (gradlew/gradlew.bat), então não é necessário instalar o Gradle separadamente.
Um ambiente local para executar o servidor (por exemplo, IntelliJ IDEA, Eclipse ou terminal).
Postman (opcional): Para testar os endpoints da API de forma visual.

Como Executar

Clonar o Repositório:
git clone <url-do-repositório>
cd AT-JAVA-2TRI-OFC


Construir o Projeto:Use o wrapper Gradle para construir o projeto:
./gradlew build

No Windows, use:
gradlew.bat build


Executar a Aplicação:Inicie o servidor Javalin, que estará disponível em http://localhost:7000:
./gradlew run

No Windows:
gradlew.bat run


Testar a API via Terminal:Use ferramentas como curl para interagir com a API:

Criar uma Tarefa:curl -X POST http://localhost:7000/tasks -H "Content-Type: application/json" -d '{"titulo":"Nova Tarefa","descricao":"Descrição da Tarefa","concluida":false}'


Listar Tarefas:curl http://localhost:7000/tasks


Buscar Tarefa por ID:curl http://localhost:7000/tasks/1


Verificar Status:curl http://localhost:7000/status




Testar a API com Postman:O Postman é uma ferramenta visual para testar APIs. Siga os passos abaixo para configurar e testar os endpoints:

Instalar o Postman: Baixe e instale o Postman em postman.com.
Criar uma Nova Requisição:
Abra o Postman e clique em "New" > "HTTP Request".
Configure os endpoints conforme abaixo:


Criar uma Tarefa (POST /tasks):
Método: POST
URL: http://localhost:7000/tasks
Headers: Adicione Content-Type: application/json
Body: Selecione raw e JSON, e insira:{
    "titulo": "Nova Tarefa",
    "descricao": "Descrição da Tarefa",
    "concluida": false
}


Clique em "Send" e verifique a resposta (status 201 e o JSON da tarefa criada).


Listar Tarefas (GET /tasks):
Método: GET
URL: http://localhost:7000/tasks
Clique em "Send" e verifique a lista de tarefas retornada.


Buscar Tarefa por ID (GET /tasks/{id}):
Método: GET
URL: http://localhost:7000/tasks/1
Clique em "Send" e verifique a tarefa retornada (ou erro 404 se não encontrada).


Verificar Status (GET /status):
Método: GET
URL: http://localhost:7000/status
Clique em "Send" e verifique o status do servidor com o timestamp.




Salvar Requisições: Crie uma coleção no Postman para salvar essas requisições e reutilizá-las facilmente.


Executar Testes:Execute os testes unitários para verificar a funcionalidade da API:
./gradlew test

No Windows:
gradlew.bat test



Endpoints da API

GET /hello: Retorna uma mensagem simples "Hello, Javalin!".
GET /status: Retorna o status do servidor com um timestamp.
POST /echo: Retorna o campo mensagem do corpo da requisição.
GET /saudacao/{nome}: Retorna uma saudação com o nome fornecido.
POST /tasks: Cria uma ou mais tarefas (aceita uma tarefa única ou uma lista).
GET /tasks: Recupera todas as tarefas.
GET /tasks/{id}: Recupera uma tarefa por seu ID.

Observações

O projeto usa um armazenamento em memória (TaskStorage.java), então as tarefas não são persistidas entre reinícios do servidor.
A API espera entradas JSON para requisições POST e retorna respostas em JSON.


