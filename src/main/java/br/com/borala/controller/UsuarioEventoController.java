package br.com.borala.controller;

import br.com.borala.service.UsuarioEdicaoEventoService;
import br.com.borala.vo.AvaliacaoEventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario-evento")
public class UsuarioEventoController {

    private UsuarioEdicaoEventoService usuarioEdicaoEventoService;

    @Autowired
    public UsuarioEventoController(UsuarioEdicaoEventoService usuarioEdicaoEventoService) {
        this.usuarioEdicaoEventoService = usuarioEdicaoEventoService;
    }

    @PatchMapping("/{id}/avaliacao")
    public ResponseEntity classificarEvento(@PathVariable("id") Integer usuarioEventoId,
                                            @RequestBody AvaliacaoEventoVO avaliacaoEventoVO) {
        final var usuarioEventoQuery = usuarioEdicaoEventoService.findById(usuarioEventoId);

        if (usuarioEventoQuery == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioEdicaoEventoService.classificarUsuarioEvento(usuarioEventoQuery, avaliacaoEventoVO.getAvaliacao()));
    }

}
