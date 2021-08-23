package br.com.zupacademy.everton.casadocodigo.livros;

import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroControlador {

    @PersistenceContext
    EntityManager manager;
    @Autowired
    private LivroRepositorio livroRepositorio;

    @PostMapping
    public LivroDTO adicionar(@RequestBody @Valid LivroForm form){
        Livro livro = form.converterEmModelo(manager);
        livro = livroRepositorio.save(livro);
        return new LivroDTO(livro);
    }

    @GetMapping()
    public List<ListaLivrosDTO> listarTodos(){
        List<Livro> livros = livroRepositorio.findAll();
        return ListaLivrosDTO.converteLista(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaDetalhada(@PathVariable("id") Long id){
        Optional<Livro> livro = livroRepositorio.findById(id);
        if (livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalhesDTO(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
