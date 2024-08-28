package med.voll.api.Infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.Models.Usuarios;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    // Busca a variavel de ambiente no application.properties
    @Value("${api.security.token.secret}")
    private String secret;



    //O secret é uma string secreta que serve como uma chave criptográfica.
    // Essa chave é crucial para a segurança do token JWT, pois é usada para gerar a assinatura digital do token.
    // Quando o token é gerado, ele é composto de três partes: header, payload, e a assinatura.
    // A assinatura é criada usando a chave secreta junto com um algoritmo de criptografia (neste caso, HMAC256).



    public String gerarToken(Usuarios usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer("SILVIO_SPRING_SECURITY") // ---> assinatura da aplicação
                    .withSubject(usuario.getLogin()) // ---> Mostra a qual usuario esse token pertence
                    .withClaim("id", usuario.getId()) // ---> para passar o id do usuario no token
                    .withExpiresAt(dataExpiracao()) // ---> duração que o token vai ficar ativo
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
           throw new RuntimeException("Erro ao gerar token:" + exception);
        }
    }

    // recuperar o usuario que esta fazendo o login || validar token


    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("SILVIO_SPRING_SECURITY")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }


    // método para criar o tempo que o token vai ficar ativo
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); // pega o horario, deixa durar 2 horas e ajusta o tempo para o brasil
    }


}
