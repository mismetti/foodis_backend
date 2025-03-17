package com.mila.foodis.business.converter;

import com.mila.foodis.business.dto.AtualizarUsuarioDTO;
import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {


    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .nome(usuarioDTO.getNome())
                .senha(usuarioDTO.getSenha())
                .bio(usuarioDTO.getBio())
                .avatarUrl(usuarioDTO.getAvatarUrl())
                .dataCriacao(usuarioDTO.getDataCriacao())
                .email(usuarioDTO.getEmail())
                .build();


    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario){ //Function<Usuario, UsuarioDTO>
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

    public Usuario atualizaUsuario(AtualizarUsuarioDTO dto, Usuario entity) {
        return Usuario.builder()
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(entity.getSenha())
                .email(dto.getEmail() != null ? dto.getEmail() : entity.getEmail())
                .bio(dto.getBio() != null ? dto.getBio() : entity.getBio())
                .avatarUrl(dto.getAvatarUrl() != null ? dto.getAvatarUrl() : entity.getAvatarUrl())
                .dataCriacao(entity.getDataCriacao())
                .build();


    }


    }
