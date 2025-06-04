package com.arturlogan.projetofinal.meme_final.repositories;

import com.arturlogan.projetofinal.meme_final.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
}
