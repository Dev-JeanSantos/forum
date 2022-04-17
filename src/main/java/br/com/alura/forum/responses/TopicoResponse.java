package br.com.alura.forum.responses;

import br.com.alura.forum.modelos.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoResponse {

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoResponse(String titulo, String mensagem, LocalDateTime dataCriacao) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }

    public TopicoResponse(Topico entity) {
        this.titulo = entity.getTitulo();
        this.mensagem = entity.getMensagem();
        this.dataCriacao = entity.getDataCriacao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public static List<TopicoResponse> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoResponse ::new).collect(Collectors.toList());
    }

}
