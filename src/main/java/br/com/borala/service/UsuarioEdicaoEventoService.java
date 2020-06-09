package br.com.borala.service;

import br.com.borala.model.UsuarioEdicaoEvento;
import br.com.borala.repository.UsuarioEdicaoEventoRepository;
import br.com.borala.vo.InscreverEventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioEdicaoEventoService {

    private UsuarioEdicaoEventoRepository usuarioEdicaoEventoRepository;

    @Autowired
    public UsuarioEdicaoEventoService(UsuarioEdicaoEventoRepository usuarioEdicaoEventoRepository) {
        this.usuarioEdicaoEventoRepository = usuarioEdicaoEventoRepository;
    }

    public void inscreverEvento(InscreverEventoVO inscreverEventoVO) {
        usuarioEdicaoEventoRepository.inscreverEvento(inscreverEventoVO.getUsuarioId(), inscreverEventoVO.getEdicaoEventoId());
    }

    public List<UsuarioEdicaoEvento> findByUsuarioId(Integer usuarioId) {
        return usuarioEdicaoEventoRepository.findByUsuarioId(usuarioId);
    }

    public Integer countByEdicaoEventoId(Integer edicaoEventoId) {
        return usuarioEdicaoEventoRepository.countByEdicaoEventoId(edicaoEventoId);
    }

    public UsuarioEdicaoEvento findById(Integer usuarioEventoId) {
        final var usuarioEventoOptional = usuarioEdicaoEventoRepository.findById(usuarioEventoId);

        if (usuarioEventoOptional.isEmpty()) {
            return null;
        }

        return usuarioEventoOptional.get();
    }

    public UsuarioEdicaoEvento classificarUsuarioEvento(UsuarioEdicaoEvento usuarioEdicaoEvento, Integer classificacao) {
        usuarioEdicaoEvento.setClassificacao(classificacao);
        return saveUsuarioEvento(usuarioEdicaoEvento);
    }

    private UsuarioEdicaoEvento saveUsuarioEvento(UsuarioEdicaoEvento usuarioEdicaoEvento) {
        return usuarioEdicaoEventoRepository.save(usuarioEdicaoEvento);
    }

}
