package br.com.alura.forum.repositories;

import br.com.alura.forum.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario>  findByEmail(String email);
}
