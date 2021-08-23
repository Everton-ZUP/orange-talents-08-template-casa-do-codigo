package br.com.zupacademy.everton.casadocodigo.validacao;

import br.com.zupacademy.everton.casadocodigo.clientes.ClienteForm;
import br.com.zupacademy.everton.casadocodigo.estado.Estado;
import br.com.zupacademy.everton.casadocodigo.estado.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ValidaEstadoDoPais implements Validator {

    @Autowired
    private EstadoRepositorio estadoRepositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        ClienteForm form = (ClienteForm) target;
        List<Estado> estados = estadoRepositorio.findAllByPaisId(form.getIdPais());
        if (estados.isEmpty()){
            return;
        }
        if (form.getIdEstado() == null){
            errors.rejectValue("idEstado","Vazio.ClienteForm.estado","");
            return;
        }
        if (estados.contains(estadoRepositorio.getById(form.getIdEstado()))){
            return;
        }
        errors.rejectValue("idEstado","NaoPertence.ClienteForm.estado","");
    }
}
