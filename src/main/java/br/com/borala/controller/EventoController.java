package br.com.borala.controller;

import br.com.borala.model.Evento;
import br.com.borala.service.EventoService;
import br.com.borala.vo.InscreverEventoVO;
import br.com.borala.vo.InsertEventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity findAllEventosPublicos() {
        return ResponseEntity.ok(eventoService.findAllEventosPublicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity findEventoById(@PathVariable("id") Integer eventoId) {
        final var evento = eventoService.findEventoById(eventoId);

        if (evento == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity insertEvento(@RequestBody InsertEventoVO evento) {
        return ResponseEntity.ok(eventoService.insertEvento(evento));
    }

    @PostMapping("/inscricao")
    public ResponseEntity inscreverEvento(@RequestBody InscreverEventoVO inscreverEventoVO) {
        eventoService.inscreverEvento(inscreverEventoVO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateEvento(@RequestBody Evento evento) {
        final var queryEvento = eventoService.findEventoById(evento.getId());

        if (queryEvento == null) return ResponseEntity.notFound().build();

        eventoService.saveEvento(evento);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity filtrarEventos(@RequestParam("titulo") String titulo,
                                         @RequestParam("cidade") String cidade,
                                         @RequestParam("categoria") Integer categoriaId) {
        return ResponseEntity.ok(eventoService.findByTituloAndCidadeAndCategoria(titulo, cidade, categoriaId));
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity findEventosByUsuario(@PathVariable("id") Integer usuarioId) {
        return ResponseEntity.ok(eventoService.findEventosByUsuario(usuarioId));
    }

    @GetMapping("/{id}/meus-eventos")
    public ResponseEntity findEventosByOrganizador(@PathVariable("id") Integer organizadorId) {
        return ResponseEntity.ok(eventoService.findEventosByOrganizador(organizadorId));
    }

}
