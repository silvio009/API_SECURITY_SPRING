package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.Dto.Medico.AtualizaMedicoDto;
import med.voll.api.Dto.Medico.CadastroMedicoDto;
import med.voll.api.Dto.Medico.DetalhesMedicoDto;
import med.voll.api.Dto.Medico.ListagemMedicoDto;
import med.voll.api.Models.Medico;
import med.voll.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("Medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;



    @GetMapping("{id}")
    public ResponseEntity<DetalhesMedicoDto> getid (@PathVariable("id") Long id){
        var page = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesMedicoDto(page));
    }



    // paginação
    //                      Qntdade||Pagina
    // localhost:8080/Medicos?size=1&page=2

    //@PageableDefault === para configurar as informações default do Pageable,Como : Quantidade (size), Ordem alfabetica(sort) e etc...
    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page =  medicoRepository.findAll(pageable).map(ListagemMedicoDto:: new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesMedicoDto>post(@RequestBody @Valid CadastroMedicoDto cadastroMedicoDto, UriComponentsBuilder uriComponentsBuilder ){
        var post = new Medico(cadastroMedicoDto);
        medicoRepository.save(post);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesMedicoDto(post));
    }


    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesMedicoDto> atualizar( @PathVariable("id")  Long id,@RequestBody @Valid AtualizaMedicoDto atualizaMedicoDto){
    var medico = medicoRepository.getReferenceById(id);
    medico.atualizarInfo(atualizaMedicoDto);
    return ResponseEntity.ok(new DetalhesMedicoDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
    medicoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
    }

}
