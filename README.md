##📦 API Security com Spring Boot e JWT
Este projeto é uma API robusta construída com Spring Boot que implementa autenticação e autorização usando JSON Web Tokens (JWT) em conjunto com Spring Security. A API é projetada para garantir que apenas usuários autenticados possam acessar endpoints protegidos.

#🚀 Funcionalidades
-🔒 Autenticação JWT: Sistema de login que gera um token JWT para usuários autenticados.

-🔑 Autorização: Controle de acesso a endpoints específicos com base em roles de usuário.

-🛡️ Integração com Spring Security: Implementação de segurança robusta e personalizada para a API.

-⚙️ Filtros Personalizados: Validação de tokens JWT em cada requisição através de filtros customizados.

#-🛠️ Tecnologias Utilizadas
-Spring Boot: Framework principal para construção da API.

-Spring Security: Para gerenciamento de autenticação e autorização.

-JWT (JSON Web Token): Autenticação baseada em tokens.

-Maven: Gerenciador de dependências.

-Java 11: Linguagem de programação utilizada.

#📝 Como Executar
Clone o repositório:

-bash
Copiar código
git clone https://github.com/silvio009/API_SECURITY_SPRING.git
Navegue até o diretório do projeto:

-bash
Copiar código
cd API_SECURITY_SPRING
Compile e execute a aplicação:

-bash
Copiar código
mvn spring-boot:run
A API estará disponível em:

-arduino
Copiar código
http://localhost:8080
🔍 Exemplo de Uso
Login: Envie uma requisição POST para /auth/login com as credenciais de usuário. Receba um token JWT para autenticar as requisições subsequentes.

Acesso a Endpoints Protegidos: Utilize o token JWT no header Authorization: Bearer <seu_token> para acessar os endpoints protegidos.
