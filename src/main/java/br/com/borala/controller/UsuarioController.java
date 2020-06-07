package br.com.borala.controller;

import br.com.borala.model.Usuario;
import br.com.borala.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        return usuarioService.insertUsuario(usuario);
    }

}
