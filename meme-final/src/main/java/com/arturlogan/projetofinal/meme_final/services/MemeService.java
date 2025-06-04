package com.arturlogan.projetofinal.meme_final.services;

import com.arturlogan.projetofinal.meme_final.entities.Meme;
import com.arturlogan.projetofinal.meme_final.repositories.MemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MemeService {

    private final MemeRepository memeRepository;

    public Meme novoMeme(Meme meme) {
        meme.setDataCadastro(LocalDate.now());
        return memeRepository.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }

}
