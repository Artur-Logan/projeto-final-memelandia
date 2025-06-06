package com.arturlogan.projetofinal.meme_final.services;

import com.arturlogan.projetofinal.meme_final.entities.CategoriaMeme;
import com.arturlogan.projetofinal.meme_final.entities.Meme;
import com.arturlogan.projetofinal.meme_final.feign.FeignClientUsuario;
import com.arturlogan.projetofinal.meme_final.feign.UsuarioFeign;
import com.arturlogan.projetofinal.meme_final.repositories.CategoriaMemeRepository;
import com.arturlogan.projetofinal.meme_final.repositories.MemeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MemeService {

    private final MemeRepository memeRepository;
    private final CategoriaMemeRepository categoriaMemeRepository;
    private final FeignClientUsuario feignClientUsuario;

    public Meme novoMeme(Meme meme) {
        UsuarioFeign usuario;
        try {
            log.info("Verificando se o usuário existe.");
            usuario = feignClientUsuario.buscarUsuario(meme.getUsuarioId());
            if (usuario == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        }
        log.info("Usuário verificado com sucesso: {}", usuario);

        if (meme.getCategoriaMeme() == null) {
            log.info("Verificando se a categoria foi informada.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não informada");
        }
        log.info("Categoria informada: {}", meme.getCategoriaMeme());

        log.info("Verificando se a categoria existe.");
        CategoriaMeme categoria = categoriaMemeRepository.findById(meme.getCategoriaMeme().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada"));

        meme.setCategoriaMeme(categoria);
        log.info("Categoria associada ao meme: {}", meme.getCategoriaMeme());
        log.info("Salvando meme no banco de dados.");
        memeRepository.save(meme);
        log.info("Meme salvo no banco de dados: {}", meme);
        return meme;
    }

    public List<Meme> listaTodosMemes() {
        log.info("Buscando a lista de todos os memes.");
        List<Meme> memes = memeRepository.findAll();
        log.info("Lista de memes retornada com sucesso.");
        return memes;
    }
}