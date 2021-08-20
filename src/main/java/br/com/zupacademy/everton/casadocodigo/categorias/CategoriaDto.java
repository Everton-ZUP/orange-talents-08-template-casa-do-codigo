package br.com.zupacademy.everton.casadocodigo.categorias;

public class CategoriaDto {
    private Long id;
    private String nome;

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
