package com.mila.foodis.infrastructure.entity;

import com.mila.foodis.infrastructure.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Document("post")
@AllArgsConstructor
public class Post {

    @Id
    private UUID id = UUID.randomUUID();
    private String titulo;
    private String conteudo;
    private String imagemUrl;
    @DBRef
    private Usuario usuario;
    private UUID usuarioId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;


}
