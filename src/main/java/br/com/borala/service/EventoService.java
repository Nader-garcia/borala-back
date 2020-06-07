package br.com.borala.service;

import br.com.borala.model.EdicaoEvento;
import br.com.borala.model.Evento;
import br.com.borala.repository.EventoRepository;
import br.com.borala.vo.InsertEventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    private final Integer SEMANAS_EDICAO_EVENTO = 4;

    private EventoRepository eventoRepository;
    private UsuarioEventoService usuarioEventoService;
    private EdicaoEventoService edicaoEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository,
                         UsuarioEventoService usuarioEventoService,
                         EdicaoEventoService edicaoEventoService) {
        this.eventoRepository = eventoRepository;
        this.usuarioEventoService = usuarioEventoService;
        this.edicaoEventoService = edicaoEventoService;
    }

    public List<Evento> findAllEventosPublicos() {
        return eventoRepository.findByPublicoTrue();
    }

    public Evento findEventoById(Integer eventoId) {
        final var eventoOptional = eventoRepository.findById(eventoId);

        if (eventoOptional.isEmpty()) {
            return null;
        }

        return eventoOptional.get();
    }

    public Evento insertEvento(InsertEventoVO eventoVO) {
        final var evento = saveEvento(Evento.valueOf(eventoVO));

        if (eventoVO.getSemanal()) {
            insertEdicoesEventoSemanal(evento, eventoVO.getDataEvento());
        } else {
            insertEdicaoEvento(evento, eventoVO.getDataEvento());
        }

        return evento;
    }

    public Evento saveEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> findEventosByUsuario(Integer usuarioId) {
        return usuarioEventoService.findByUsuarioId(usuarioId).stream().map(it -> it.getEvento()).collect(Collectors.toList());
    }

    public List<Evento> findEventosByOrganizador(Integer organizadorId) {
        return eventoRepository.findByOrganizadorId(organizadorId);
    }

    public List<Evento> findEventosByCidade(String cidade) {
        return eventoRepository.findByCidadeContaining(cidade);
    }

    public List<Evento> findEventosByCategoria(Integer categoriaId) {
        return eventoRepository.findByCategoriaId(categoriaId);
    }

    private void insertEdicoesEventoSemanal(Evento evento, ZonedDateTime data) {
        for (Integer i = 0; i < SEMANAS_EDICAO_EVENTO; i++) {
            insertEdicaoEvento(evento, ZonedDateTime.from(data).plusDays(7 * i));
        }
    }

    private void insertEdicaoEvento(Evento evento, ZonedDateTime data) {
        edicaoEventoService.saveEdicaoEvento(EdicaoEvento.builder()
                .evento(evento)
                .dataEvento(data)
                .build());
    }

}
