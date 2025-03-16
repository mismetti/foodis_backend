package com.mila.foodis.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Document("usuario")
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String avatarUrl;
    private LocalDateTime dataCriacao;
    private String bio;

}
