package br.com.zupacademy.everton.casadocodigo.pais;

import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank @UniqueValue(fieldName = "nome",domainClass = Pais.class)
    private String nome;

    public Pais converterEmModelo() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
