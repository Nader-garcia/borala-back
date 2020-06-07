package br.com.borala.repository;

import br.com.borala.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Integer> {

    List<Evento> findByOrganizadorId(Integer organizadorId);
    List<Evento> findByCidadeContaining(String cidade);
    List<Evento> findByCategoriaId(Integer categoriaId);
    List<Evento> findByPublicoTrue();

}
