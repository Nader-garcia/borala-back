package br.com.borala.controller;

import br.com.borala.model.Usuario;
import br.com.borala.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository _usuarioRepository){
        usuarioRepository = _usuarioRepository;
    }

    @GetMapping
    public List<Usuario> getAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable("id") Integer id){
        return usuarioRepository.findById(id).get();
    }
}
