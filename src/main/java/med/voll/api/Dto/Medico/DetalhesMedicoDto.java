package med.voll.api.Dto.Medico;

import med.voll.api.Models.Endereco;
import med.voll.api.Models.Especialidade;
import med.voll.api.Models.Medico;

public record DetalhesMedicoDto(long id, String nome, String email, String telefone, String crm, Especialidade especialidade,
                                Endereco endereco){

    public DetalhesMedicoDto(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getTelefone(),medico.getCrm(),medico.getEspecialidade(),medico.getEndereco());
    }

}



