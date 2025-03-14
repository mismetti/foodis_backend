package com.mila.foodis.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private String avatarUrl;
    private String dataCriacao;
    private String bio;
}
