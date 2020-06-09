package br.com.borala.repository;

import br.com.borala.model.UsuarioEdicaoEvento;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UsuarioEdicaoEventoRepository extends CrudRepository<UsuarioEdicaoEvento, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuario_edicao_evento (usuario_id, edicao_evento_id)" +
            "VALUES (?, ?)", nativeQuery = true)
    Integer inscreverEvento(Integer usuarioId, Integer edicaoEventoId);

    List<UsuarioEdicaoEvento> findByUsuarioId(Integer usuarioId);

    Integer countByEdicaoEventoId(Integer edicaoEventoId);

}
