package com.mila.foodis.business.service;

import com.mila.foodis.business.converter.PostConverter;
import com.mila.foodis.business.dto.AtualizarPostDTO;
import com.mila.foodis.business.dto.AtualizarUsuarioDTO;
import com.mila.foodis.business.dto.PostDTO;
import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.PostRepository;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostConverter converter;
    private final UsuarioRepository userRepository;
    private final PostRepository postRepository;

    public PostDTO salvarPost(PostDTO dto, String usuarioId) {

        var usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário nao encontrado."));

        Post post = converter.paraPost(dto);
        post.setUsuario(usuario);


        return converter.paraPostDTO(postRepository.save(post));
    }

    public List<PostDTO> pesquisarPostsFeitosPeloUsuario(String usuarioId) {

        return postRepository.findPostsByUsuarioId(usuarioId)
                .stream()
                .map(post -> converter.paraPostDTO(post))
                .toList();
    }

    public void removerPost(String id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Usuário não existe.");
        }
        postRepository.deleteById(id);

    }


    public PostDTO updatePost(AtualizarPostDTO dto, String id) {
        try{
            Post entity = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar o Id."));
            Post post = converter.atualizaPost(dto, entity);
            return converter.paraPostDTO(postRepository.save(post));
        } catch (RuntimeException e){
            throw new RuntimeException("Nao foi possivel atualizar estes dados.");
        }
    }

}
