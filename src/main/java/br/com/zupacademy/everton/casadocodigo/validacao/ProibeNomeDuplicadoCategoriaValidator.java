package br.com.zupacademy.everton.casadocodigo.validacao;

import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaForm;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    CategoriaRepositorio repositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CategoriaForm cat = (CategoriaForm) target;
        if (repositorio.findByNome(cat.getNome()).isPresent()){
            errors.rejectValue("nome","NotDuplicated.CategoriaForm.Nome",
                    "Nome duplicado"+cat.getNome());
        }
    }
}
