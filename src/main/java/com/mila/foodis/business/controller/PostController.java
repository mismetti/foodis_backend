package com.mila.foodis.business.controller;

import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.PostRepository;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
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

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<Post>> pesquisarUsuario(@PathVariable String id){

        return ResponseEntity.ok(postRepository.findByUsuarioId(id));
    }

    @PostMapping
    public ResponseEntity<Post> salvarPost(@RequestBody Post post){

        Optional<Usuario> usuario = usuarioRepository.findById(post.getUsuarioId());

        Post novoPost = postRepository.save(post);
        return ResponseEntity.ok(novoPost);
    }


}
