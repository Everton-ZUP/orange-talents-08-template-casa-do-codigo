package br.com.zupacademy.everton.casadocodigo.autores;

import java.time.LocalDateTime;

public class AutorDTO {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instanteDeCadastro;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instanteDeCadastro = autor.getInstanteDeCadastro();
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getInstanteDeCadastro() {
        return instanteDeCadastro;
    }

}
