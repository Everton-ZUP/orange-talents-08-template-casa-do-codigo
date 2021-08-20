package br.com.zupacademy.everton.casadocodigo.autores;

import br.com.zupacademy.everton.casadocodigo.validacao.ProibeDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorRepositorio repositorio;

    /**
     * Método para chamar as validações customizadas
     * o método com essa anotação vai ser Executado toda vez que uma request for feita para esse endpoint
     */
    @InitBinder
    public void init (WebDataBinder binder){
        binder.addValidators(new ProibeDuplicado(repositorio));
    }

    /**
     * Método responsável por adicionar um novo autor no sistema
     * @param autorForm os atributos deste objeto não podem ser nulos
     * @return Os dados do autor cadastrado
     */
    @PostMapping
    public AutorDTO adicionar(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.converteEmModelo();
        repositorio.save(autor);
        return new AutorDTO(autor);
    }

}
