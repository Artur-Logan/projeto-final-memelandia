package com.arturlogan.projetofinal.meme_final.repositories;

import com.arturlogan.projetofinal.meme_final.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
}
