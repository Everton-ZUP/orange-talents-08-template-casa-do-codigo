package br.com.zupacademy.everton.casadocodigo.livros;

import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroControlador {

    @PersistenceContext
    EntityManager manager;
    @Autowired
    private LivroRepositorio livroRepositorio;

    @PostMapping
    @RequestMapping("/livro")
    public LivroDTO adicionar(@RequestBody @Valid LivroForm form){
        Livro livro = form.converterEmModelo(manager);
        livro = livroRepositorio.save(livro);
        return new LivroDTO(livro);
    }

    @GetMapping
    @RequestMapping("/livros")
    public List<ListaLivrosDTO> listarTodos(){
        List<Livro> livros = livroRepositorio.findAll();
        return ListaLivrosDTO.converteLista(livros);
    }

}
