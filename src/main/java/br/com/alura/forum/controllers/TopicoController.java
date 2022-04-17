package br.com.alura.forum.controllers;

import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.responses.TopicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

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

}
