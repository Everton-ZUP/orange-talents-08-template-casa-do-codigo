package br.com.zupacademy.everton.casadocodigo.validacao;


import br.com.zupacademy.everton.casadocodigo.autores.AutorForm;
import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepositorio repositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        AutorForm request = (AutorForm) target;
        if (repositorio.findByEmail(request.getEmail()).isPresent()){
            errors.rejectValue("email","NotDuplicated.AutorForm.email",
                    "Já existe um autor(a) com este e-mail: "+request.getEmail());
        }
    }
}
