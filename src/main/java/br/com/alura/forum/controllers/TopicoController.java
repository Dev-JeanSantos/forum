package br.com.alura.forum.controllers;

import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.requestes.TopicoRequest;
import br.com.alura.forum.requestes.UpdateTopicoRequest;
import br.com.alura.forum.responses.TopicoResponse;
import br.com.alura.forum.responses.TopicoResponseDetalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<TopicoResponse> getAllTopicos(String nomeCurso){
       if (nomeCurso == null){
           List<Topico> topicos = repository.findAll();
           return TopicoResponse.converter(topicos);
       }else{
           List<Topico> topicos = repository.findByCursoNome(nomeCurso);
           return TopicoResponse.converter(topicos);
       }
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> insert(@Valid @RequestBody TopicoRequest request) {
        Topico entidade = request.converter(cursoRepository);
        repository.save(entidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoResponse(entidade));
    }

    @GetMapping(value = "/{id}")
    public TopicoResponseDetalhes findById(@PathVariable Long id) {
        Topico topico = repository.getOne(id);
        return new TopicoResponseDetalhes(topico);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<TopicoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody UpdateTopicoRequest request) {
        Topico entidade = request.converter(id, repository);
        return ResponseEntity.ok(new TopicoResponse(entidade));
    }
}
