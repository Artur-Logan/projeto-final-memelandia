package com.arturlogan.projetofinal.meme_final.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "usuario-service", url = "http://localhost:8081")
public interface FeignClientUsuario {

    @RequestMapping(method = RequestMethod.POST, path = "/usuarios")
    UsuarioFeign criarNovoUsuario(@RequestBody FeignClientUsuario novoUsuarioVo);

    @RequestMapping(method = RequestMethod.GET, path = "/usuarios")
    List<UsuarioFeign> encontrarTodos();

    @RequestMapping(method = RequestMethod.GET, path = "/usuarios/{id}")
    UsuarioFeign buscarUsuario(@PathVariable("id") String id);
}
