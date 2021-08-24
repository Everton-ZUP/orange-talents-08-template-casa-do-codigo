package br.com.zupacademy.everton.casadocodigo.clientes;

import br.com.zupacademy.everton.casadocodigo.validacao.ValidaEstadoDoPais;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ClienteRepositorio repostorio;

    @Autowired
    private ValidaEstadoDoPais validaEstadoDoPais;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaEstadoDoPais);
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converterEmModelo(manager);
        repostorio.save(cliente);
        return ResponseEntity.ok(cliente.getId());
    }
}
