package med.voll.api.Infra.errors;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // AVISA O SPRING QUE ESSA CLASSE IRA TRATAR ERROS NÃO GENERICOS
public class TratadorDeErros {


    @ExceptionHandler(EntityNotFoundException.class) //Sempre que der notFound o spring utilizara esse método
    public ResponseEntity tratar404(){
      return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratar400(MethodArgumentNotValidException exception){

        // PERGAR OS ERRORS
        var errors = exception.getFieldErrors();
        // VOLTAR PARA O USUARIO APENAS O CONSTRUTOR COM ERRO E MENSAGEM EM FORMATO JSON
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErrosValidacaodto::new).toList());
    }



    // DTO PARA PEGAR OS ERROR DE CAMPO E MENSAGEM PARA RETORNAR NO JSON DE 400
    private record DadosErrosValidacaodto(String campo,String mensagem){
     public DadosErrosValidacaodto(FieldError error){
         this(error.getField(),error.getDefaultMessage());
     }
    }


}
