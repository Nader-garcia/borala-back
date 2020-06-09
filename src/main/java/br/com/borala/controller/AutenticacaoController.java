package br.com.borala.controller;

import br.com.borala.service.UsuarioService;
import br.com.borala.vo.AutenticacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private UsuarioService usuarioService;

    @Autowired
    public AutenticacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity autenticacao(@RequestBody AutenticacaoVO autenticacaoVO) {
        final var usuarioQuery = usuarioService.findByEmailAndSenha(autenticacaoVO);

        if (usuarioQuery == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioQuery.getId());
    }

}
