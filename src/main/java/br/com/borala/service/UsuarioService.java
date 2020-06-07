package br.com.borala.service;

import br.com.borala.model.Usuario;
import br.com.borala.repository.UsuarioRepository;
import br.com.borala.vo.AutenticacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByEmailAndSenha(AutenticacaoVO autenticacaoVO) {
        final var usuarioOptional = usuarioRepository.findByEmailAndSenha(autenticacaoVO.getEmail(), autenticacaoVO.getSenha());

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        return usuarioOptional.get();
    }

}
