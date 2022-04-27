package br.com.alura.forum.responses;

import br.com.alura.forum.enuns.StatusTopico;
import br.com.alura.forum.modelos.Resposta;
import br.com.alura.forum.modelos.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoResponseDetalhes {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaResponse> respostas;

    public TopicoResponseDetalhes(String titulo,
                                  String mensagem,
                                  LocalDateTime dataCriacao,
                                  String nomeAutor,
                                  StatusTopico status,
                                  List<Resposta> respostas) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.nomeAutor = nomeAutor;
        this.status = status;
    }

    public TopicoResponseDetalhes(Topico entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.mensagem = entity.getMensagem();
        this.dataCriacao = entity.getDataCriacao();
        this.nomeAutor = entity.getAutor().getNome();
        this.status = entity.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(entity.getRespostas().stream().map(RespostaResponse::new)
                .collect(Collectors.toList()));
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public List<RespostaResponse> getRespostas() {
        return respostas;
    }

}
