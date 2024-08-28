package med.voll.api.Dto.Medico;

import med.voll.api.Models.Especialidade;
import med.voll.api.Models.Medico;

public record ListagemMedicoDto(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public ListagemMedicoDto(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
