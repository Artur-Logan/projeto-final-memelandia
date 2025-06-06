package com.arturlogan.projetofinal.meme_final.services;

import com.arturlogan.projetofinal.meme_final.entities.CategoriaMeme;
import com.arturlogan.projetofinal.meme_final.feign.FeignClientUsuario;
import com.arturlogan.projetofinal.meme_final.feign.UsuarioFeign;
import com.arturlogan.projetofinal.meme_final.repositories.CategoriaMemeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CategoriaMemeService {

    private final CategoriaMemeRepository categoriaMemeRepository;

    private FeignClientUsuario feignClientUsuario;

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        UsuarioFeign usuario;
        try {
            log.info("Verificando se o usuário existe.");
            usuario = feignClientUsuario.buscarUsuario(categoriaMeme.getUsuarioId());
            if (usuario == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        }
        log.info("Usuário verificado com sucesso: {}", usuario);

        log.info("Salvando categoria no banco de dados.");

        categoriaMemeRepository.save(categoriaMeme);

        log.info("Categoria salva com sucesso: {}", categoriaMeme);
        return categoriaMeme;
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        log.info("Buscando a lista de todas as categorias.");
        List<CategoriaMeme> memes = categoriaMemeRepository.findAll();
        log.info("Lista de categorias retornada com sucesso.");
        return memes;
    }
}
