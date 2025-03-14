package com.mila.foodis.business.dto;

import com.mila.foodis.infrastructure.entity.Usuario;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostDTO {

    public UUID id = UUID.randomUUID();
    public String titulo;
    public String conteudo;
    public String imagemUrl;
    public Usuario usuario;
    public UUID usuarioId;
    public LocalDateTime dataCriacao;
    public LocalDateTime dataAtualizacao;

}
