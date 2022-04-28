package br.com.alura.forum.controllers;

import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.requestes.TopicoRequest;
import br.com.alura.forum.requestes.UpdateTopicoRequest;
import br.com.alura.forum.responses.TopicoResponse;
import br.com.alura.forum.responses.TopicoResponseDetalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public Page<TopicoResponse> getAllTopicos(@RequestParam(required = false) String nomeCurso,
                                              @RequestParam int pag,@RequestParam int qtd){
        Pageable pageable = PageRequest.of(pag, qtd);

       if (nomeCurso == null){
           Page<Topico> topicos = repository.findAll(pageable);
           return TopicoResponse.converter(topicos);
       }else{
           Page<Topico> topicos = repository.findByCursoNome(nomeCurso, pageable);
           return TopicoResponse.converter(topicos);
       }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponse> insert(@Valid @RequestBody TopicoRequest request) {
        Topico entidade = request.converter(cursoRepository);
        repository.save(entidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoResponse(entidade));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicoResponseDetalhes> findById(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent()){
            return ResponseEntity.ok(new TopicoResponseDetalhes(topico.get()));
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<TopicoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody UpdateTopicoRequest request) {

        Optional<Topico> opt = repository.findById(id);
        if(opt.isPresent()){
            Topico entidade = request.converter(id, repository);
            return ResponseEntity.ok(new TopicoResponse(entidade));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Topico> opt = repository.findById(id);
        if(opt.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
