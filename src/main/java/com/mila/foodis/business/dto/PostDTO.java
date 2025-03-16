package com.mila.foodis.business.dto;

import com.mila.foodis.infrastructure.entity.Usuario;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostDTO {

    private String id;
    private String titulo;
    private String conteudo;
    private String imagemUrl;
    private Usuario usuario;
    private UUID usuarioId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
