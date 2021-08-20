package br.com.zupacademy.everton.casadocodigo.categorias;

import br.com.zupacademy.everton.casadocodigo.validacao.ProibeNomeDuplicadoCategoriaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaRepositorio repositorio;

    @Autowired
    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
    }

    @PostMapping
    public CategoriaDto adicionar (@RequestBody @Valid CategoriaForm formCategoria){
        Categoria categoria = formCategoria.converterEmModelo();
        categoria = repositorio.save(categoria);
        return new CategoriaDto(categoria);
    }

}
