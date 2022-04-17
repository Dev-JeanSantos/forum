package br.com.alura.forum.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Resposta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String mensagem;
        @ManyToOne
        private Topico topico;
        private LocalDateTime dataCriacao = LocalDateTime.now();
        @ManyToOne
        private Usuario autor;
        private Boolean solucao = false;

        @Deprecated
        public Resposta() {
        }

        public Resposta(Long id,
                        String mensagem,
                        Topico topico,
                        LocalDateTime dataCriacao,
                        Usuario autor,
                        Boolean solucao) {
                this.id = id;
                this.mensagem = mensagem;
                this.topico = topico;
                this.dataCriacao = dataCriacao;
                this.autor = autor;
                this.solucao = solucao;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getMensagem() {
                return mensagem;
        }

        public void setMensagem(String mensagem) {
                this.mensagem = mensagem;
        }

        public Topico getTopico() {
                return topico;
        }

        public void setTopico(Topico topico) {
                this.topico = topico;
        }

        public LocalDateTime getDataCriacao() {
                return dataCriacao;
        }

        public void setDataCriacao(LocalDateTime dataCriacao) {
                this.dataCriacao = dataCriacao;
        }

        public Usuario getAutor() {
                return autor;
        }

        public void setAutor(Usuario autor) {
                this.autor = autor;
        }

        public Boolean getSolucao() {
                return solucao;
        }

        public void setSolucao(Boolean solucao) {
                this.solucao = solucao;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Resposta)) return false;
                Resposta resposta = (Resposta) o;
                return Objects.equals(getId(), resposta.getId()) && Objects.equals(getMensagem(), resposta.getMensagem()) && Objects.equals(getTopico(), resposta.getTopico()) && Objects.equals(getDataCriacao(), resposta.getDataCriacao()) && Objects.equals(getAutor(), resposta.getAutor()) && Objects.equals(getSolucao(), resposta.getSolucao());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getMensagem(), getTopico(), getDataCriacao(), getAutor(), getSolucao());
        }
}
