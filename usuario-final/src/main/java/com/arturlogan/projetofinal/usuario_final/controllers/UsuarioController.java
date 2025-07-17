package com.arturlogan.projetofinal.usuario_final.controllers;


import com.arturlogan.projetofinal.usuario_final.entities.Usuario;
import com.arturlogan.projetofinal.usuario_final.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        return usuarioService.listaTodosUsuarios();
    }

    @PostMapping
    public Usuario novoUsuario(@Valid @RequestBody Usuario usuario) throws MethodArgumentNotValidException {

        return usuarioService.novoUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@Valid @PathVariable String id){
        return usuarioService.buscar(id);
    }
}
