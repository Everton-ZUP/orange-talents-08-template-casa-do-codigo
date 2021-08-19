package br.com.zupacademy.everton.casadocodigo.validacao;

public class CamposDeErro {
    private String campo;
    private String Mensagem;

    public CamposDeErro(String campo, String mensagem) {
        this.campo = campo;
        Mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return Mensagem;
    }
}
