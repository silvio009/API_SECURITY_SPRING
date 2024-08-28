package med.voll.api.Dto.Medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Models.Endereco;
import med.voll.api.Models.Medico;

public record AtualizaMedicoDto(
        Long id,
        @NotNull
        String nome,

        String telefone,

        Endereco endereco

) {
}
