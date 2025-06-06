package com.arturlogan.projetofinal.meme_final.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
public class CategoriaMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria_meme")
    private Long id;

    private String nome;
    private String descricao;
    private Date dataCadastro;

    // Substitua o relacionamento ManyToOne por um campo simples
    @Column(name = "usuario_id", nullable = false)
    private String usuarioId;
}
