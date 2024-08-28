package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.Dto.DadosTokenJWTdto;
import med.voll.api.Dto.DetalhesAutenticacaoDto;
import med.voll.api.Infra.security.TokenService;
import med.voll.api.Models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")

// CLASSE PARA REALIZAR LOGIN NO NOSSO SISTEMA
public class AutenticacaoController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager manager;


     // METODO PARA REALIZAR LOGIN
    @PostMapping
    public ResponseEntity<DadosTokenJWTdto> login(@RequestBody @Valid DetalhesAutenticacaoDto detalhesAutenticacaoDto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(detalhesAutenticacaoDto.login(),detalhesAutenticacaoDto.senha());

        // busca o usuario no banco de dados
        var Autenticacao = manager.authenticate(authenticationToken);

        // Autenticacao representa o usuario que esta logado || getPrincipal() pra pegar o usuario logado

        var tokenJWT = tokenService.gerarToken((Usuarios) Autenticacao.getPrincipal());

        // devolvendo um dto que contem o token
        return ResponseEntity.ok(new DadosTokenJWTdto(tokenJWT));
    }
}
