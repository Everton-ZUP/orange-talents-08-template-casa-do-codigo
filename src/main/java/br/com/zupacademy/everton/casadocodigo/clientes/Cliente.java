package br.com.zupacademy.everton.casadocodigo.clientes;

import br.com.zupacademy.everton.casadocodigo.estado.Estado;
import br.com.zupacademy.everton.casadocodigo.pais.Pais;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @NotBlank @Email String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank String documento;
    private @NotBlank String endereco;
    private @NotBlank String complemento;
    private @NotBlank String cidade;
    private @NotNull @ManyToOne Pais pais;
    private @ManyToOne Estado estado;
    private @NotBlank String telefone;
    private @NotBlank String cep;


    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        Assert.isTrue(estado.pertenceAoPais(this.pais.getId()),"Este estado não pertence ao pais escolhido");
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }
}
