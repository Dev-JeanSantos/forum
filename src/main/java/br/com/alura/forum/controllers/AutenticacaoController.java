package br.com.alura.forum.controllers;

import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.requestes.LoginRequest;
import br.com.alura.forum.requestes.TopicoRequest;
import br.com.alura.forum.requestes.UpdateTopicoRequest;
import br.com.alura.forum.responses.TopicoResponse;
import br.com.alura.forum.responses.TopicoResponseDetalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<TopicoResponse> autenticar(@RequestBody @Valid LoginRequest req) {

        System.out.println(req.getEmail());
        System.out.println(req.getSenha());

        return ResponseEntity.ok().build();
    }
}