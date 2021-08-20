package br.com.zupacademy.everton.casadocodigo.categorias;

import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria converterEmModelo() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }
}
