package com.mila.foodis.business.converter;

import com.mila.foodis.business.dto.AtualizarPostDTO;
import com.mila.foodis.business.dto.PostDTO;
import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class PostConverter {

    private final UsuarioConverter usuarioConverter;

    public Post paraPost(PostDTO dto){
        return Post.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .conteudo(dto.getConteudo())
                .imagemUrl(dto.getImagemUrl())
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .build();

    }

    public PostDTO paraPostDTO(Post entity){
        return PostDTO.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .conteudo(entity.getConteudo())
                .imagemUrl(entity.getImagemUrl())
                .usuarioDTO(usuarioConverter.paraUsuarioDTO(entity.getUsuario()))
                .dataAtualizacao(entity.getDataAtualizacao())
                .dataCriacao(entity.getDataCriacao())
                .build();

    }

    public Post atualizaPost(AtualizarPostDTO postDTO, Post entity) {
        return Post.builder()
                .titulo(postDTO.getTitulo() != null ? postDTO.getTitulo() : entity.getTitulo())
                .id(entity.getId())
                .conteudo(postDTO.getConteudo() != null ? postDTO.getConteudo() : entity.getConteudo())
                .imagemUrl(postDTO.getImagemUrl() != null ? postDTO.getImagemUrl() : entity.getImagemUrl())
                .usuario(postDTO.getUsuarioDTO() != null ? usuarioConverter.paraUsuario(postDTO.getUsuarioDTO()) : entity.getUsuario())
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(entity.getDataCriacao())
                .build();

    }

}
