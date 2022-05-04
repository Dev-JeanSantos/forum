package br.com.alura.forum.repositories;

import br.com.alura.forum.modelos.Curso;
import br.com.alura.forum.modelos.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    void DeveriaBuscarUsuarioPeloEmail() {

        String email = "aluno@email.com";
        Optional<Usuario> usuario = repository.findByEmail(email);
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(email, usuario.get().getEmail());
    }

    @Test
    void deveriaRetornarNullQuandoBuscarUmUsuarioQueNaoEmailNãoExistaNaBase() {
        String email = "aluno2@email.com";
        Optional<Usuario> usuario = repository.findByEmail(email);
        Assertions.assertTrue(usuario.isEmpty());
    }
}