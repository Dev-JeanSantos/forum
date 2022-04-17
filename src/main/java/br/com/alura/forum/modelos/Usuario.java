package br.com.alura.forum.modelos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String senha;

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Deprecated
    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }
}
