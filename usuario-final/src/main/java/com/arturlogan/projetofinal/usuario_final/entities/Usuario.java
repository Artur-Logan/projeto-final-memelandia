package com.arturlogan.projetofinal.usuario_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Usuario {

    @Id
    private String id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Column(name = "data_cadastro", nullable = false)
    @NotNull
    private LocalDate dataCadastro;

    @PrePersist
    public void criarId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
