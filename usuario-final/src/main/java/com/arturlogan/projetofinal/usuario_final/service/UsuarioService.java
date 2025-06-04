package com.arturlogan.projetofinal.usuario_final.service;

import com.arturlogan.projetofinal.usuario_final.entities.Usuario;
import com.arturlogan.projetofinal.usuario_final.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario novoUsuario(Usuario usuario) {
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return usuarioRepository.findAll();
    }
}
