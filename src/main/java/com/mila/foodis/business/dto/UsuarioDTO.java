package com.mila.foodis.business.dto;

import jakarta.validation.constraints.Email;
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
public class UsuarioDTO {

    private String id;

    @NotNull
    @NotEmpty
    private String nome;

    @Email
    @NotNull
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    private String avatarUrl;
    private LocalDateTime dataCriacao;
    private String bio;
}
