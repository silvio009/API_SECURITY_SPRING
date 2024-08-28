package med.voll.api.Dto.Usuario;

import med.voll.api.Models.Usuarios;

public record DetalhesUsuarioDto(Long id, String login) {
    public DetalhesUsuarioDto(Usuarios usuario){
        this(usuario.getId(), usuario.getLogin());
    }
}
