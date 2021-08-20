package br.com.zupacademy.everton.casadocodigo.categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
