package br.com.borala.repository;

import br.com.borala.model.UsuarioEvento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioEventoRepository extends CrudRepository<UsuarioEvento, Integer> {

    List<UsuarioEvento> findByUsuarioId(Integer usuarioId);

}
