package br.com.borala.repository;

import br.com.borala.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
