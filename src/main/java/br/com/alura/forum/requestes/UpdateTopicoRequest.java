package br.com.alura.forum.requestes;

import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateTopicoRequest {

    private String titulo;
    @Size(max = 200)
    @NotBlank(message = "Campo Obrigatório")
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico converter(Long id, TopicoRepository repository) {

        Topico topico = repository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
