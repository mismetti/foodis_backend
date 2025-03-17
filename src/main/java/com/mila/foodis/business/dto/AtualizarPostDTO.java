package com.mila.foodis.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AtualizarPostDTO {

    private String id;
    private String titulo;
    private String conteudo;
    private String imagemUrl;
    private UsuarioDTO usuarioDTO;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;


}
