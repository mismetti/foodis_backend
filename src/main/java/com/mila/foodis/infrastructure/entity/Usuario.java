package com.mila.foodis.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("usuario")
public class Usuario {

    @Id
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private String avatarUrl;
    private String dataCriacao;
    private String bio;

    public Usuario(UUID id) {
        this.id = id;
    }

}
