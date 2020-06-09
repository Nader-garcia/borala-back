package br.com.borala.controller;

import br.com.borala.model.CategoriaEvento;
import br.com.borala.service.CategoriaEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias-evento")
public class CategoriaEventoController {

    private CategoriaEventoService categoriaEventoService;

    @Autowired
    public CategoriaEventoController(CategoriaEventoService categoriaEventoService) {
        this.categoriaEventoService = categoriaEventoService;
    }

    @GetMapping
    public List<CategoriaEvento> findAll() {
        return categoriaEventoService.findAll();
    }

}
