package br.com.zupacademy.everton.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pais")
public class PaisControlador {

    @Autowired
    private PaisRepositorio repositorio;

    @PostMapping
    public Map<String,String> cadastrar(@RequestBody @Valid PaisForm form){
        Pais pais = form.converterEmModelo();
        pais = repositorio.save(pais);
        HashMap<String,String> retorno = new HashMap<>();
        retorno.put("ID",pais.getId().toString());
        retorno.put("Nome", pais.getNome());
        return retorno;
    }

}
