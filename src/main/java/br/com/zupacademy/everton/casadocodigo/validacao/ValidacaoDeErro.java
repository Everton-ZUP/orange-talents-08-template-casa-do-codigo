package br.com.zupacademy.everton.casadocodigo.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidacaoDeErro {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RetornoErro validaErro (MethodArgumentNotValidException erro){

        List<ObjectError> errosGlobais = erro.getBindingResult().getGlobalErrors();
        List<FieldError> erroCampos = erro.getBindingResult().getFieldErrors();
        
        return constroiErro(errosGlobais,erroCampos);
    }

    private RetornoErro constroiErro(List<ObjectError> errosGlobais, List<FieldError> erroCampos) {
        RetornoErro retorno = new RetornoErro();
        errosGlobais.forEach(erro -> retorno.adicionaErro(getErrorMessage(erro)));
        erroCampos.forEach(erro -> {
            String mensagem = getErrorMessage(erro);
            retorno.addFieldErro(erro.getField(), (String) erro.getRejectedValue(), mensagem);
        });
        return retorno;
    }

    private String getErrorMessage(ObjectError erro) {
        return messageSource.getMessage(erro, LocaleContextHolder.getLocale());
    }

}
