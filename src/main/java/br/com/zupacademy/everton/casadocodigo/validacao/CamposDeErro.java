package br.com.zupacademy.everton.casadocodigo.validacao;

public class CamposDeErro {
    private String campo;
    private Object valor;
    private String mensagem;

    public CamposDeErro(Object value, String campo, String mensagem) {
        this.campo = campo;
        this.valor =  value;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }
    public Object getValor() {
        return valor;
    }
    public String getMensagem() {
        return mensagem;
    }
}
