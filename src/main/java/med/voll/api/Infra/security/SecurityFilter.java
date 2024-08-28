package med.voll.api.Infra.security;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Sinaliza para os Spring que essa é uma classe generica
public class SecurityFilter extends OncePerRequestFilter{


    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    // uma vez por requisição

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

        // se tiver token na requesição ele pega o usuario que esta logando
        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);

            // se vier pra ca o token esta valido
            var usuario = usuarioRepository.findByLogin(subject);// -----> recuperando o obj usuario do banco de dados
            var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities()); // -----> DTO que representa o usuario
            SecurityContextHolder.getContext().setAuthentication(authentication); //  -----> força a autenticação
        }

       // para chamar os proximos filtros || se não tiver proximo ele vai para os Controllers
       filterChain.doFilter(request,response);
    }


    // metodo para recuperar o token no cabeçalho Authorization

    private String recuperarToken(HttpServletRequest request) {
        // pega o token que esta sendo enviado no postman
        var authorizationHeader = request.getHeader("Authorization");
       if (authorizationHeader != null){
           return authorizationHeader.replace("Bearer ", "");
       }

        // se não tiver token ele devolve null
        return null;
    }
}
