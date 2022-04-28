package br.com.alura.forum.responses;

import br.com.alura.forum.enuns.StatusTopico;
import br.com.alura.forum.modelos.Resposta;
import br.com.alura.forum.modelos.Topico;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoResponse {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoResponse(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }

    public TopicoResponse(Topico entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.mensagem = entity.getMensagem();
        this.dataCriacao = entity.getDataCriacao();
    }

    public Long getId() {
        return id;
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

    public static Page<TopicoResponse> converter(Page<Topico> topicos) {
        return topicos.map(TopicoResponse::new);
    }

}