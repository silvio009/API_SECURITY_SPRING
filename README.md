📚 Seções
Este projeto de API é composto por várias funcionalidades e componentes principais:

Autenticação JWT: Sistema de login que gera um token JWT para usuários autenticados, garantindo que apenas usuários autorizados possam acessar os recursos protegidos da API.
Autorização: Implementa controle de acesso a endpoints específicos com base em roles definidas para os usuários, protegendo a aplicação contra acessos indevidos.
Integração com Spring Security: Utilização do Spring Security para gerenciar a autenticação e autorização, fornecendo uma solução de segurança robusta e confiável.
Filtros Personalizados: Implementação de filtros customizados para interceptar e validar tokens JWT em cada requisição, garantindo a integridade e segurança das operações.
💼 Tecnologias Utilizadas
Para o desenvolvimento desta API, foram utilizadas as seguintes tecnologias:

Spring Boot: Framework principal para construção da API, oferecendo uma base sólida e escalável.
Spring Security: Ferramenta de segurança utilizada para gerenciar a autenticação e autorização de forma integrada com o Spring Boot.
JWT (JSON Web Token): Tecnologia utilizada para autenticação baseada em tokens, permitindo uma comunicação segura entre cliente e servidor.
Maven: Gerenciador de dependências que facilita o build e a configuração do projeto.
Java 11: Linguagem de programação utilizada para o desenvolvimento da API, garantindo performance e compatibilidade com as bibliotecas e frameworks.
🔍 Exemplo de Uso
Login: Envie uma requisição POST para /auth/login com as credenciais de usuário. Receba um token JWT para autenticar as requisições subsequentes.

Acesso a Endpoints Protegidos: Utilize o token JWT no header Authorization: Bearer <seu_token> para acessar os endpoints protegidos.
