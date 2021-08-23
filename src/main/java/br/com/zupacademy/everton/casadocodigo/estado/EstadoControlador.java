package br.com.zupacademy.everton.casadocodigo.estado;

import br.com.zupacademy.everton.casadocodigo.validacao.ProibeEstadoDuplicadoNoPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {

    @Autowired
    private ProibeEstadoDuplicadoNoPais vali;

    @Autowired
    private EstadoRepositorio repositorio;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init (WebDataBinder binder){
        binder.addValidators(vali);
    }

    @PostMapping
    public HashMap<String,String> adicionar(@RequestBody @Valid EstadoForm form){
        Estado estado = form.converterEmModelo(manager);
        estado = repositorio.save(estado);

        HashMap<String,String> est = new HashMap<>();
        est.put("id",estado.getId().toString());
        est.put("Nome",estado.getNome());
        est.put("Pais",estado.getPais().getNome());
        return est;
    }
}
