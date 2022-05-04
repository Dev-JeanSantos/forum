package br.com.alura.forum.repositories;

import br.com.alura.forum.modelos.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    void deveriaBuscarUmCursoPeloNome() {
        String nome = "HTML 5";
        Curso curso = repository.findByNome(nome);
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nome, curso.getNome());
    }
    @Test
    void deveriaRetornarNullQuandoBuscarUmCursoQueNaoExisteNaBase() {
        String nome = "HTML";
        Curso curso = repository.findByNome(nome);
        Assertions.assertNull(curso);
    }
}