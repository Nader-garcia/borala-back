package br.com.borala.service;

import br.com.borala.model.EdicaoEvento;
import br.com.borala.model.Evento;
import br.com.borala.repository.EventoRepository;
import br.com.borala.vo.ConsultarEventoVO;
import br.com.borala.vo.EventoVO;
import br.com.borala.vo.InscreverEventoVO;
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
    private UsuarioEdicaoEventoService usuarioEdicaoEventoService;
    private EdicaoEventoService edicaoEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository,
                         UsuarioEdicaoEventoService usuarioEdicaoEventoService,
                         EdicaoEventoService edicaoEventoService) {
        this.eventoRepository = eventoRepository;
        this.usuarioEdicaoEventoService = usuarioEdicaoEventoService;
        this.edicaoEventoService = edicaoEventoService;
    }

    public void inscreverEvento(InscreverEventoVO inscreverEventoVO) {
        usuarioEdicaoEventoService.inscreverEvento(inscreverEventoVO);
    }

    public List<EventoVO> findAllEventosPublicos() {
        return mapEdicaoEventoToEventoVO(edicaoEventoService.findByEventoPublicoTrue());
    }

    public List<EventoVO> findByTituloAndCidadeAndCategoria(String titulo, String cidade, Integer categoriaId) {
        return edicaoEventoService.findByTituloAndCidadeAndCategoria(titulo, cidade, categoriaId).stream().map(EventoVO::valueOf).collect(Collectors.toList());
    }

    public ConsultarEventoVO findEventoById(Integer edicaoEventoId) {
        final var edicaoEvento = edicaoEventoService.findById(edicaoEventoId);

        if (edicaoEvento == null) {
            return null;
        }

        final var consultarEventoVO = ConsultarEventoVO.valueOf(edicaoEvento);
        consultarEventoVO.setParticipantes(usuarioEdicaoEventoService.countByEdicaoEventoId(edicaoEventoId));

        return consultarEventoVO;
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

    public List<EventoVO> findEventosByUsuario(Integer usuarioId) {
        return mapEdicaoEventoToEventoVO(usuarioEdicaoEventoService.findByUsuarioId(usuarioId).stream().map(it -> it.getEdicaoEvento()).collect(Collectors.toList()));
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

    private List<EventoVO> mapEdicaoEventoToEventoVO(List<EdicaoEvento> edicoesEvento) {
        return edicoesEvento.stream().map(EventoVO::valueOf).collect(Collectors.toList());
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
