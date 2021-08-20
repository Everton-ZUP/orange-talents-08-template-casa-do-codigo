package br.com.zupacademy.everton.casadocodigo.validacao;

public class CamposDeErro {
    private String campo;
    private String valor;
    private String mensagem;

    public CamposDeErro(String value, String campo, String mensagem) {
        this.campo = campo;
        this.valor = value;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }
    public String getValor() {
        return valor;
    }
    public String getMensagem() {
        return mensagem;
    }
}
