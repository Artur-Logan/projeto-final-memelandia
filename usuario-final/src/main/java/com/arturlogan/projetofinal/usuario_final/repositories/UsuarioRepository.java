package com.arturlogan.projetofinal.usuario_final.repositories;

import com.arturlogan.projetofinal.usuario_final.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
