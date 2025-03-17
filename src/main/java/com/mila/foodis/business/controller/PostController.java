package com.mila.foodis.business.controller;

import com.mila.foodis.business.dto.AtualizarPostDTO;
import com.mila.foodis.business.dto.AtualizarUsuarioDTO;
import com.mila.foodis.business.dto.PostDTO;
import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.business.service.PostService;
import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.PostRepository;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    private final UsuarioRepository usuarioRepository;

    private final PostService postService;

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<PostDTO>> pesquisarPostFeitosPeloUsuario(@PathVariable String id){

        List<PostDTO> pesquisaDePosts = postService.pesquisarPostsFeitosPeloUsuario(id);
        return ResponseEntity.ok(pesquisaDePosts);
    }

    @PostMapping(path = "{id}")
    public ResponseEntity<PostDTO> salvarPost(@RequestBody PostDTO post, @PathVariable String id){

        PostDTO novoPost = postService.salvarPost(post, id);

        return ResponseEntity.ok(novoPost);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletarPost(@PathVariable String id){
        postService.removerPost(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping
    public ResponseEntity<PostDTO> alterarPost(@Valid @RequestBody AtualizarPostDTO dto, @RequestParam String id){
        PostDTO postDTO = postService.updatePost(dto, id);
        return ResponseEntity.ok(postDTO);
    }

}
