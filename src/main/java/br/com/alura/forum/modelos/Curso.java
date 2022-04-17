package br.com.alura.forum.modelos;

import java.util.Objects;

public class Curso {

    private Long id;
    private String nome;
    private String categoria;

    @Deprecated
    public Curso() {
    }

    public Curso(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return Objects.equals(getId(), curso.getId()) && Objects.equals(getNome(), curso.getNome()) && Objects.equals(getCategoria(), curso.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCategoria());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
