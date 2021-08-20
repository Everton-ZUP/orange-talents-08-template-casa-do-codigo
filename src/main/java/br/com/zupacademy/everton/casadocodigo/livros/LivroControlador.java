package br.com.zupacademy.everton.casadocodigo.livros;

import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroControlador {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private LivroRepositorio livroRepositorio;

    @PostMapping
    public LivroDTO adicionar(@RequestBody @Valid LivroForm form){
        Livro livro = form.converterEmModelo(autorRepositorio, categoriaRepositorio);
        livro = livroRepositorio.save(livro);
        return new LivroDTO(livro);
    }

}
