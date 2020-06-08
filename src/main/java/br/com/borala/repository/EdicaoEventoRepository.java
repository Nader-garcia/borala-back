package br.com.borala.repository;

import br.com.borala.model.EdicaoEvento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EdicaoEventoRepository extends CrudRepository<EdicaoEvento, Integer> {

    List<EdicaoEvento> findByEventoPublicoTrue();

}
