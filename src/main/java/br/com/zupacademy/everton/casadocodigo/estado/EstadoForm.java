package br.com.zupacademy.everton.casadocodigo.estado;

import br.com.zupacademy.everton.casadocodigo.pais.Pais;
import br.com.zupacademy.everton.casadocodigo.validacao.ExistEntity;
import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    private String nome;

    @ExistEntity(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converterEmModelo(EntityManager manager) {
        return new Estado(this.nome, manager.find(Pais.class,this.idPais));
    }
}
