package com.arturlogan.projetofinal.meme_final.controllers;

import com.arturlogan.projetofinal.meme_final.entities.CategoriaMeme;
import com.arturlogan.projetofinal.meme_final.services.CategoriaMemeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaMemeController {

    private final CategoriaMemeService categoriaMemeService;

    @GetMapping
    public List<CategoriaMeme> listasTodos(){
        return categoriaMemeService.listaTodasCategorias();
    }

    @PostMapping
    public CategoriaMeme salvar(@RequestBody CategoriaMeme categoriaMeme){
        return categoriaMemeService.novaCategoriaMeme(categoriaMeme);
    }
}
