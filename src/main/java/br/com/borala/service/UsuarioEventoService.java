package br.com.borala.service;

import br.com.borala.model.UsuarioEvento;
import br.com.borala.repository.UsuarioEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioEventoService {

    private UsuarioEventoRepository usuarioEventoRepository;

    @Autowired
    public UsuarioEventoService(UsuarioEventoRepository usuarioEventoRepository) {
        this.usuarioEventoRepository = usuarioEventoRepository;
    }

    public List<UsuarioEvento> findByUsuarioId(Integer usuarioId) {
        return usuarioEventoRepository.findByUsuarioId(usuarioId);
    }

    public UsuarioEvento findById(Integer usuarioEventoId) {
        final var usuarioEventoOptional = usuarioEventoRepository.findById(usuarioEventoId);

        if (usuarioEventoOptional.isEmpty()) {
            return null;
        }

        return usuarioEventoOptional.get();
    }

    public UsuarioEvento classificarUsuarioEvento(UsuarioEvento usuarioEvento, Integer classificacao) {
        usuarioEvento.setClassificacao(classificacao);
        return saveUsuarioEvento(usuarioEvento);
    }

    private UsuarioEvento saveUsuarioEvento(UsuarioEvento usuarioEvento) {
        return usuarioEventoRepository.save(usuarioEvento);
    }

}
