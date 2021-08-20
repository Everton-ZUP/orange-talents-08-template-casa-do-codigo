package br.com.zupacademy.everton.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

public class RetornoErro {
    private List<String> errosGlobais = new ArrayList<>();
    private List<CamposDeErro> firldErrors = new ArrayList<>();


    public void adicionaErro(String errorMessage) {
        errosGlobais.add(errorMessage);
    }

    public void addFieldErro(String field, String Value, String mensagem) {
        CamposDeErro fieldError = new CamposDeErro(Value, field, mensagem);
        firldErrors.add(fieldError);
    }

    public List<String> getErrosGlobais() {
        return errosGlobais;
    }

    public List<CamposDeErro> getFirldErrors() {
        return firldErrors;
    }
}
