package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.Dto.Usuario.CadastroUsuarioDto;
import med.voll.api.Dto.Usuario.DetalhesUsuarioDto;
import med.voll.api.Models.Usuarios;
import med.voll.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto,
                                                   UriComponentsBuilder uri){
        //criar um usuário com os valores do DTO
        var usuario = new Usuarios(dto.login(), passwordEncoder.encode(dto.senha()));
        //cadastrar o usuário no banco de dados
        usuarioRepository.save(usuario);
        //criar o retorno da API (url)
        var uriBuilder = uri.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        //retornar o status 201 Created
        return ResponseEntity.created(uriBuilder).body(new DetalhesUsuarioDto(usuario));
    }

}
