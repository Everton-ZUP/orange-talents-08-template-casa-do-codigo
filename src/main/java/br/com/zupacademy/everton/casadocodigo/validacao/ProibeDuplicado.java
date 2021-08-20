package br.com.zupacademy.everton.casadocodigo.validacao;

import br.com.zupacademy.everton.casadocodigo.autores.AutorForm;
import br.com.zupacademy.everton.casadocodigo.autores.AutorRepositorio;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaForm;
import br.com.zupacademy.everton.casadocodigo.categorias.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProibeDuplicado implements Validator {

    private JpaRepository repositorio;
    private String nomeClasse = "";

    public ProibeDuplicado(JpaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        if (clazz.getName().contentEquals("br.com.zupacademy.everton.casadocodigo.categorias.CategoriaForm")){
            this.nomeClasse = "br.com.zupacademy.everton.casadocodigo.categorias.CategoriaForm";
            return CategoriaForm.class.isAssignableFrom(clazz);
        }else{
            return AutorForm.class.isAssignableFrom(clazz);
        }
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        if (nomeClasse.contentEquals( "br.com.zupacademy.everton.casadocodigo.categorias.CategoriaForm")){
            CategoriaRepositorio repositorioCate = (CategoriaRepositorio) repositorio;
            CategoriaForm cat = (CategoriaForm) target;
            if (repositorioCate.findByNome(cat.getNome()).isPresent()){
                errors.rejectValue("nome","NotDuplicated.CategoriaForm.Nome",
                        "Nome duplicado"+cat.getNome());
            }
        }else{
            System.out.println("Chgou aqui");
            AutorRepositorio repositorioAut = (AutorRepositorio) repositorio;
            AutorForm request = (AutorForm) target;
            if (repositorioAut.findByEmail(request.getEmail()).isPresent()){
                errors.rejectValue("email","NotDuplicated.AutorForm.email",
                        "Já existe um autor(a) com este e-mail: "+request.getEmail());
            }
        }
    }

}
