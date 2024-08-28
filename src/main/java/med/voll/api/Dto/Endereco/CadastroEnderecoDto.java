package med.voll.api.Dto.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroEnderecoDto(

         @NotBlank
         String logradouro,

         @NotBlank
         String bairro,

         @NotBlank
         @Size(max = 8, message = "O Cep deve conter 8 digitos. Sem ( - ) ")
         String cep,


         @NotBlank
         String cidade,

         @NotBlank
         String uf,

         String complemento,

         @NotBlank
         String numero) {




}
