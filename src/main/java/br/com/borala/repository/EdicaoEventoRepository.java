package br.com.borala.repository;

import br.com.borala.model.EdicaoEvento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EdicaoEventoRepository extends CrudRepository<EdicaoEvento, Integer> {

    List<EdicaoEvento> findByEventoPublicoTrue();

    @Query(value = "SELECT ee " +
            "FROM EdicaoEvento ee " +
            "WHERE ee.evento.publico = true " +
            "AND ee.evento.ativo = true " +
            "AND LOWER(ee.evento.titulo) LIKE LOWER(CONCAT('%', ?1,'%')) " +
            "AND LOWER(ee.evento.cidade) LIKE LOWER(CONCAT('%', ?2,'%')) " +
            "AND (ee.evento.categoria.id = ?3 OR ?3 IS NULL) " +
            "ORDER BY ee.id DESC")
    List<EdicaoEvento> findByTituloAndCidadeAndCategoria(String titulo, String cidade, Integer categoriaId);

}
