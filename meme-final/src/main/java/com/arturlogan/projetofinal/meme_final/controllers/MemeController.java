package com.arturlogan.projetofinal.meme_final.controllers;

import com.arturlogan.projetofinal.meme_final.entities.Meme;
import com.arturlogan.projetofinal.meme_final.services.MemeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
@AllArgsConstructor
public class MemeController {

    private final MemeService memeService;

    @GetMapping()
    public List<Meme> buscaMemes() {
        return memeService.listaTodosMemes();
    }

    @PostMapping()
    public Meme novoMeme(@RequestBody Meme meme) {
        return memeService.novoMeme(meme);
    }
}
