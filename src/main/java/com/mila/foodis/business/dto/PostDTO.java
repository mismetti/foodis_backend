package com.mila.foodis.business.dto;

import com.mila.foodis.infrastructure.entity.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {

    private String id;

    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    @NotEmpty
    private String conteudo;
    private String imagemUrl;
    private UsuarioDTO usuarioDTO;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
