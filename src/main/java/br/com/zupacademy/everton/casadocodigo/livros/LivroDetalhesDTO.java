package br.com.zupacademy.everton.casadocodigo.livros;

import br.com.zupacademy.everton.casadocodigo.autores.AutorDTO;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaDto;
import org.springframework.http.ResponseEntity;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Optional;

public class LivroDetalhesDTO{
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private HashMap<String,String> autor = new HashMap<>();

    public LivroDetalhesDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor.put("nome",livro.getAutor().getNome());
        this.autor.put("descricao",livro.getAutor().getDescricao());
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public HashMap<String, String> getAutor() {
        return autor;
    }
}
