package com.arturlogan.projetofinal.meme_final.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    private Long id;

    private String nome;
    private String descricao;
    private Date dataCadastro;

    @Column(name = "usuario_id", nullable = false)
    private String usuarioId; //

    @ManyToOne
    @JoinColumn(name = "categoria_meme_id")
    private CategoriaMeme categoriaMeme;
}