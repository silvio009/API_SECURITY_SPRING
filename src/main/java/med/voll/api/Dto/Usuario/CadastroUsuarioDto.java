package med.voll.api.Dto.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDto(
        @NotBlank
        @Size(max = 50)
        String login,
        @NotBlank
        String senha
) {

}
