package br.com.zupacademy.everton.casadocodigo.clientes;

import br.com.zupacademy.everton.casadocodigo.estado.Estado;
import br.com.zupacademy.everton.casadocodigo.pais.Pais;
import br.com.zupacademy.everton.casadocodigo.validacao.CpfOuCnpj;
import br.com.zupacademy.everton.casadocodigo.validacao.ExistEntity;
import br.com.zupacademy.everton.casadocodigo.validacao.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    private @NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email") String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank @CpfOuCnpj @UniqueValue(domainClass = Cliente.class, fieldName = "documento") String documento;
    private @NotBlank String endereco;
    private @NotBlank String complemento;
    private @NotBlank String cidade;
    private @NotNull @ExistEntity(domainClass = Pais.class, fieldName = "id") Long idPais;
    private Long idEstado;
    private @NotBlank String telefone;
    private @NotBlank String cep;


    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco,
                       String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Cliente converterEmModelo(EntityManager manager) {
        Pais pais = manager.find(Pais.class,this.idPais);
        Cliente cliente = new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais,telefone,cep);
        if (this.idEstado != null){
            Estado estado = manager.find(Estado.class, this.idEstado);
            cliente.setEstado(estado);
        }
        return cliente;
    }
}
