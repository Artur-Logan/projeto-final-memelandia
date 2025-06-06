package com.arturlogan.projetofinal.meme_final.feign;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioFeign {

    private String id; // Corrigido para String

    private String nome;

    private String email;

    private Date dataCadastro;

    //private String idNovoUsuario;
}
