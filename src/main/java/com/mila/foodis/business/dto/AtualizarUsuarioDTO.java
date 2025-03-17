package com.mila.foodis.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AtualizarUsuarioDTO {

    private String id;
    private String nome;
    @Email
    private String email;
    private String avatarUrl;
    private String bio;

}
