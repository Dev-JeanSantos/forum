package br.com.alura.forum.config.validacao;

public class ErrorDeFormularioResponse {

    private String campo;
    private String erro;

    public ErrorDeFormularioResponse(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
