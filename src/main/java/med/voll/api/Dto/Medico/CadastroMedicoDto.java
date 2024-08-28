package med.voll.api.Dto.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.voll.api.Models.Endereco;
import med.voll.api.Models.Especialidade;

public record CadastroMedicoDto(

        // NOTBLANK APENAS PARA CAMPOS DE STRING
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 100, min = 2 , message = "O nome deve ter entre 2 caracters a 100")
        String nome,
        @NotBlank
        @NotNull
        @Email
        @Size(max = 100, min = 2 , message = "O Email deve ter entre 2 caracters a 100")
        String email,


        @NotNull
        @Size(max = 12, min = 1 , message ="O telefone deve conter 11 digitos")
        String telefone,


        @NotNull
        @Size(max = 6, min = 1, message = "O número do crm do medico deve conter 7 digitos")
        String crm,


        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid // ---------> outro record(validar tbm o outro obj que está sendo referencia nessa classe)
        Endereco endereco) {
}
