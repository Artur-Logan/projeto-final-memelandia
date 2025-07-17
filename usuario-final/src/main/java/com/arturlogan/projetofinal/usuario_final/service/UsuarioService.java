package com.arturlogan.projetofinal.usuario_final.service;

import com.arturlogan.projetofinal.usuario_final.entities.Usuario;
import com.arturlogan.projetofinal.usuario_final.exceptions.UsuarioNotFoundException;
import com.arturlogan.projetofinal.usuario_final.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario novoUsuario(Usuario usuario) {
        log.info("Criando usuário: {}", usuario.getNome());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        log.debug("Usuário criado com sucesso: {}", usuarioSalvo.toString());
        return usuarioSalvo;
    }

    public List<Usuario> listaTodosUsuarios() {
        log.info("Recebendo lista de Usuario");
        return usuarioRepository.findAll();
    }

    public Usuario buscar(String id) {
        log.info("Buscando usuario com id: {}", id);
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
    }
}
