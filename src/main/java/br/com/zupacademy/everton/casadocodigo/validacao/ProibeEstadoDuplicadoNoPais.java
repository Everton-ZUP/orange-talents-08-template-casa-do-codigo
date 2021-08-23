package br.com.zupacademy.everton.casadocodigo.validacao;

import br.com.zupacademy.everton.casadocodigo.estado.EstadoForm;
import br.com.zupacademy.everton.casadocodigo.estado.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEstadoDuplicadoNoPais implements Validator {

    @Autowired
    private EstadoRepositorio repositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        EstadoForm form = (EstadoForm) target;
        if (repositorio.findByNomeAndPaisId(form.getNome(),form.getIdPais()).isPresent()){
            errors.rejectValue("nome","NotDuplicated.EstadoForm.nome","");
        }
    }
}
