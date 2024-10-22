
# ChatBot Uniube Aberta - Backend

## Índice
- Visão Geral
- Características
- Tecnologias Utilizadas
- Pré-requisitos
- Instalação
- Configuração
- Uso
- Estrutura do Projeto
- Testes
- Contribuição
- Licença
- Contato

## Visão Geral
O ChatBot Uniube Aberta - Backend é uma aplicação desenvolvida em Spring Boot que fornece uma API REST para interagir com um chatbot alimentado pelo modelo GPT-4 da OpenAI. A aplicação gerencia as solicitações do usuário, processa as mensagens através do serviço de chatbot e retorna respostas formatadas.

## Características
- **API RESTful**: Endpoints para enviar mensagens e receber respostas do chatbot.
- **CORS Configurado**: Permite comunicação segura entre o frontend Angular e o backend.
- **Integração com OpenAI**: Utiliza a API do OpenAI para gerar respostas inteligentes.
- **Segurança**: Gestão de chaves API e configurações de segurança.
- **Testes Automatizados**: Testes de integração para garantir a estabilidade da aplicação.
- **Configuração Flexível**: Utiliza application.properties para configurações personalizáveis.

## Tecnologias Utilizadas
- Spring Boot - Framework principal.
- Java 21 - Linguagem de programação.
- Maven - Gerenciador de dependências.
- Lombok - Redução de boilerplate no código.
- Spring AI - Integração com serviços de AI.
- H2 Database - Banco de dados em memória para desenvolvimento.
- JUnit 5 - Framework de testes.
- ModelMapper - Mapeamento de objetos.

## Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina as seguintes ferramentas:
- Java JDK 21
- Maven
- Git

## Instalação

### Clone o Repositório
```bash
git clone https://github.com/seu-usuario/chatbot-backend.git
```

### Navegue para o Diretório do Projeto
```bash
cd chatbot-backend
```

### Instale as Dependências
```bash
mvn clean install
```

## Configuração

### Configurar as Propriedades da Aplicação
Abra o arquivo `application.properties` localizado em `src/main/resources/` e configure as seguintes propriedades:

```properties
spring.application.name=ChatBot - Uniube Aberta
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4
logging.level.org.springframework.ai.chat.client.advisor=DEBUG
```
- **spring.ai.openai.api-key**: Chave API da OpenAI. Recomenda-se utilizar variáveis de ambiente para segurança.
- **spring.ai.openai.chat.options.model**: Modelo do OpenAI a ser utilizado (ex: gpt-4).

### Configurar Variáveis de Ambiente
Defina a variável de ambiente `OPENAI_API_KEY` com a sua chave API da OpenAI. Em sistemas Unix-based, você pode fazer isso temporariamente no terminal:
```bash
export OPENAI_API_KEY=suachaveapi
```
Para definir permanentemente, adicione a linha acima no seu arquivo de configuração de shell (como `.bashrc` ou `.zshrc`).

## Uso

### Iniciar a Aplicação
Execute o comando abaixo para iniciar a aplicação Spring Boot:
```bash
mvn spring-boot:run
```
A aplicação será iniciada em `http://localhost:8080/`.

### Endpoints Disponíveis

#### GET /chat
- **Descrição**: Envia uma mensagem ao chatbot e recebe a resposta.

- **Parâmetros de Query**:
    - `message` (String) - Mensagem do usuário.
    - `prompt` (String, opcional) - Prompt do sistema para o chatbot.

- **Exemplo de Requisição**:
```bash
curl "http://localhost:8080/chat?message=Olá&prompt=Você+é+um+assistente+útil"
```

- **Resposta**:
```json
{
  "content": "Olá! Como posso ajudar você hoje?"
}
```

## Estrutura do Projeto
A seguir, uma visão geral da estrutura dos diretórios e arquivos mais importantes:
```
chatbot-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── com/
│   │   │           └── johnlaff/
│   │   │               └── chatbot/
│   │   │                   ├── ChatBotUniubeAbertaApplication.class
│   │   │                   ├── application/
│   │   │                   │   ├── config/
│   │   │                   │   │   └── CorsConfig.class
│   │   │                   │   └── controllers/
│   │   │                   │       └── ChatController.class
│   │   │                   └── domain/
│   │   │                       └── services/
│   │   │                           └── ChatService.class
│   │   ├── resources/
│   │   │   └── application.properties
│   ├── test/
│   │   └── java/
│   │       └── br/
│   │           └── com/
│   │               └── johnlaff/
│   │                   └── chatbot/
│   │                       └── ChatBotUniubeAbertaApplicationTests.class
├── pom.xml
└── README.md
```

### Componentes Principais
- **ChatBotUniubeAbertaApplication**: Classe principal para iniciar a aplicação Spring Boot.
- **Config**
    - `CorsConfig.class`: Configuração de CORS para permitir requisições do frontend Angular.
- **Controllers**
    - `ChatController.class`: Controlador REST que gerencia as requisições de chat.
- **Services**
    - `ChatService.class`: Serviço que interage com a API do OpenAI para processar mensagens.
- **Recursos**
    - `application.properties`: Arquivo de configuração da aplicação.

## Testes

### ChatBotUniubeAbertaApplicationTests
Classe de testes para verificar se o contexto da aplicação carrega corretamente.

### Testes
Para executar os testes automatizados, utilize o comando:
```bash
mvn test
```
Os testes estão localizados em `src/test/java/br/com/johnlaff/chatbot/ChatBotUniubeAbertaApplicationTests.class`.

## Contribuição
Contribuições são bem-vindas! Se você deseja contribuir para este projeto, por favor, siga os passos abaixo:
1. Fork este Repositório
2. Crie uma Branch para sua Feature
```bash
git checkout -b feature/NovaFeature
```
3. Faça Commit das Suas Alterações
```bash
git commit -m "Adiciona nova feature"
```
4. Push para a Branch
```bash
git push origin feature/NovaFeature
```
5. Abra um Pull Request

## Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato
Se você tiver qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato:
- **Nome**: John Laff
- **Email**: johnlaff@example.com
- **LinkedIn**: John Laff
- **GitHub**: johnlaff

© 2024 John Laff. Todos os direitos reservados.
