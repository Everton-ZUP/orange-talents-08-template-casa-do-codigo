package br.com.zupacademy.everton.casadocodigo.autores;

import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueValue(domainClass = Autor.class, fieldName = "Email")
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converteEmModelo() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    public String getEmail() {
        return this.email;
    }
}
