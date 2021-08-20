package br.com.zupacademy.everton.casadocodigo.categorias;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    private String nome;

    public Categoria converterEmModelo() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }
}
