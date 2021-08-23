package br.com.zupacademy.everton.casadocodigo.estado;

import br.com.zupacademy.everton.casadocodigo.pais.Pais;
import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull @ManyToOne
    private Pais pais;

    public Estado() {    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertenceAoPais(Long id) {
        return this.id == id;
    }
}
