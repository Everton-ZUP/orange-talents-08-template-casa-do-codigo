package br.com.zupacademy.everton.casadocodigo.livros;

import br.com.zupacademy.everton.casadocodigo.autores.Autor;
import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import br.com.zupacademy.everton.casadocodigo.categorias.Categoria;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import br.com.zupacademy.everton.casadocodigo.validacao.ExistEntity;
import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Length(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @NotNull @ExistEntity(domainClass = Categoria.class,fieldName = "id")
    private Long categoria;
    @NotNull @ExistEntity(domainClass = Autor.class,fieldName = "id")
    private Long autor;

    public LivroForm(String titulo, String resumo, BigDecimal preco, Integer numeroPaginas, String isbn, Long categoria, Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro converterEmModelo(AutorRepositorio autorRepositorio, CategoriaRepositorio categoriaRepositorio) {
        Autor autor = autorRepositorio.findById(this.autor).get();
        Categoria categoria = categoriaRepositorio.findById(this.categoria).get();
        return new Livro(this.titulo,this.resumo,this.sumario,this.preco,this.numeroPaginas,this.isbn,this.dataPublicacao,categoria,autor);
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
