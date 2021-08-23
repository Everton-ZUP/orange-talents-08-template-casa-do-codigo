package br.com.zupacademy.everton.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

public class RetornoErro {
    private List<String> errosGlobais = new ArrayList<>();
    private List<CamposDeErro> fieldErrors = new ArrayList<>();


    public void adicionaErro(String errorMessage) {
        errosGlobais.add(errorMessage);
    }

    public void addFieldErro(String field, Object Value, String mensagem) {
        CamposDeErro fieldError = new CamposDeErro(Value, field, mensagem);
        fieldErrors.add(fieldError);
    }

    public List<String> getErrosGlobais() {
        return errosGlobais;
    }

    public List<CamposDeErro> getFieldErrors() {
        return fieldErrors;
    }
}
