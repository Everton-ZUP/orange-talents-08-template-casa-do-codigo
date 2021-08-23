package br.com.zupacademy.everton.casadocodigo.livros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaLivrosDTO {

    private Long id;
    private String titulo;

    public ListaLivrosDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<ListaLivrosDTO> converteLista(List<Livro> livros) {
        return livros.stream().map(ListaLivrosDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
}
