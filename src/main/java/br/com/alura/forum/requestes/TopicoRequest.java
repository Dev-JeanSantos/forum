package br.com.alura.forum.requestes;

import br.com.alura.forum.modelos.Curso;
import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TopicoRequest {
    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 5, max = 30)
    private String titulo;
    @Size(max = 200)
    @NotBlank(message = "Campo Obrigatório")
    private String mensagem;
    @NotBlank(message = "Campo Obrigatório")
    private String nomeCurso;

    public TopicoRequest(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
