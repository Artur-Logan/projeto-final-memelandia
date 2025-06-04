package com.arturlogan.projetofinal.usuario_final.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioVo {

    private Long id;

    private String nome;

    private String email;

    private LocalDate dataCadastro;
}
