API Security com Spring Boot e JWT
Este projeto é uma API construída com Spring Boot que implementa autenticação e autorização usando JSON Web Tokens (JWT) em conjunto com Spring Security. A API é protegida, garantindo que apenas usuários autenticados possam acessar determinados endpoints.

Funcionalidades
Autenticação JWT: Implementação de um sistema de login que gera um token JWT para o usuário autenticado.
Autorização: Proteção de endpoints específicos com base em roles definidas para os usuários.
Integração com Spring Security: Uso do Spring Security para gerenciar autenticação e autorização, garantindo segurança robusta para a API.
Criação de Filtros Personalizados: Implementação de filtros para interceptar e validar tokens JWT em cada requisição.
Tecnologias Utilizadas
Spring Boot: Framework principal para construção da API.
Spring Security: Para gerenciamento de autenticação e autorização.
JWT (JSON Web Token): Para autenticação baseada em tokens.
Maven: Gerenciador de dependências.
Java 11: Linguagem de programação utilizada.
Como Executar
Clone este repositório:
bash
Copiar código
git clone https://github.com/silvio009/API_SECURITY_SPRING.git
Navegue até o diretório do projeto:
bash
Copiar código
cd API_SECURITY_SPRING
Compile e execute a aplicação:
bash
Copiar código
mvn spring-boot:run
A API estará disponível em http://localhost:8080.
Exemplo de Uso
Login: Envie um POST para /auth/login com as credenciais de usuário. Receba um token JWT para autenticar as requisições subsequentes.
Acesso a Endpoints Protegidos: Utilize o token JWT no header Authorization: Bearer <seu_token> para acessar endpoints protegidos.
