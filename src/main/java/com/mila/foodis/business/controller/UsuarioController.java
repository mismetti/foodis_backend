package com.mila.foodis.business.controller;

import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.business.service.UsuarioService;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        var novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping("/listarTodosUsuarios")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }


    @GetMapping(path = "{email}")
    public ResponseEntity<UsuarioDTO> pesquisarUsuario(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id){
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editaUsuario(@Valid @RequestBody UsuarioDTO dto, @RequestParam("id") String id){
        UsuarioDTO usuario = usuarioService.updateUsuario(dto, id);
        return ResponseEntity.ok(usuario);
    }


}
