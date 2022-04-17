package br.com.alura.forum.controllers;

import br.com.alura.forum.modelos.Curso;
import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.responses.TopicoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

      @GetMapping()
      public List<TopicoResponse> getAllTopicos(){
          Topico topico = new Topico("Problemas InteliJ",
                  "A IDE está bugada",
                  new Curso("JAVA", "Linguagem de Programção"));
          return TopicoResponse.converter(Arrays.asList(topico, topico, topico));
      }

}
