package br.com.borala.service;

import br.com.borala.model.EdicaoEvento;
import br.com.borala.repository.EdicaoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdicaoEventoService {

    private EdicaoEventoRepository edicaoEventoRepository;

    @Autowired
    public EdicaoEventoService(EdicaoEventoRepository edicaoEventoRepository) {
        this.edicaoEventoRepository = edicaoEventoRepository;
    }

    public EdicaoEvento findById(Integer edicaoEventoId) {
        final var edicaoEventoOptional = edicaoEventoRepository.findById(edicaoEventoId);

        if (edicaoEventoOptional.isEmpty()) {
            return null;
        }

        return edicaoEventoOptional.get();
    }

    public List<EdicaoEvento> findByEventoPublicoTrue() {
        return edicaoEventoRepository.findByEventoPublicoTrue();
    }

    public EdicaoEvento saveEdicaoEvento(EdicaoEvento edicaoEvento) {
        return edicaoEventoRepository.save(edicaoEvento);
    }

    public List<EdicaoEvento> findByTituloAndCidadeAndCategoria(String titulo, String cidade, Integer categoriaId) {
        return edicaoEventoRepository.findByTituloAndCidadeAndCategoria(titulo, cidade, categoriaId);
    }

}
