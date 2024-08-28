package med.voll.api.Models;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.Dto.Medico.AtualizaMedicoDto;
import med.voll.api.Dto.Medico.CadastroMedicoDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Medico(CadastroMedicoDto cadastroMedicoDto) {
        nome = cadastroMedicoDto.nome();
        email = cadastroMedicoDto.email();
        telefone = cadastroMedicoDto.telefone();
        crm = cadastroMedicoDto.crm();
        especialidade = cadastroMedicoDto.especialidade();
        endereco = new Endereco(cadastroMedicoDto.endereco());
    }

    public void atualizarInfo(AtualizaMedicoDto atualizaMedicoDto) {
        if (atualizaMedicoDto.nome()!= null){
            nome  = atualizaMedicoDto.nome();
        }
        if(atualizaMedicoDto.telefone()!= null){
            telefone = atualizaMedicoDto.telefone();
        }
        if (atualizaMedicoDto.endereco()!= null){
            endereco.AtualizarEndereco(atualizaMedicoDto.endereco());
        }
    }





   // CODIGOS PARA VER OS COMANDOS SQL NO TERMINAL

    // spring.jpa.show-sql=true
    // spring.jpa.properties.hibernate.format_sql=true


  // CODIGOS PARA NÃO DEVOLVER O TRACE PARA O USUARIO

   // server.error.include-stacktrace=never



}
