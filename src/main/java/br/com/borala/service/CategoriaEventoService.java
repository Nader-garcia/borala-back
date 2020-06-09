package br.com.borala.service;

import br.com.borala.model.CategoriaEvento;
import br.com.borala.repository.CategoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEventoService {

    private CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public List<CategoriaEvento> findAll() {
        return (List<CategoriaEvento>) categoriaEventoRepository.findAll();
    }

}
