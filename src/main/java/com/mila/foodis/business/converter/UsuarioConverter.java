package com.mila.foodis.business.converter;

import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {


    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .senha(usuarioDTO.getSenha())
                .bio(usuarioDTO.getBio())
                .avatarUrl(usuarioDTO.getAvatarUrl())
                .dataCriacao(usuarioDTO.getDataCriacao())
                .email(usuarioDTO.getEmail())
                .build();


    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .bio(usuario.getBio())
                .avatarUrl(usuario.getAvatarUrl())
                .dataCriacao(usuario.getDataCriacao())
                .email(usuario.getEmail())
                .build();


    }

    public Usuario atualizaUsuario(UsuarioDTO usuarioDTO, Usuario entity) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .bio(usuarioDTO.getBio() != null ? usuarioDTO.getBio() : entity.getBio())
                .avatarUrl(entity.getAvatarUrl())
                .dataCriacao(entity.getDataCriacao())
                .build();


    }


    }
