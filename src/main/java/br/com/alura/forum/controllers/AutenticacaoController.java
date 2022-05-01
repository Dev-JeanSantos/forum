package br.com.alura.forum.controllers;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.modelos.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.requestes.LoginRequest;
import br.com.alura.forum.requestes.TopicoRequest;
import br.com.alura.forum.requestes.UpdateTopicoRequest;
import br.com.alura.forum.responses.TokenResponse;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<TokenResponse> autenticar(@RequestBody @Valid LoginRequest req) {
        UsernamePasswordAuthenticationToken dadosLogin = req.converter();
        try {
            Authentication authenticate = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}