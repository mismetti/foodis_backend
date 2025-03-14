package com.mila.foodis.business.controller;

import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.business.service.UsuarioService;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarPost(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<Optional<Usuario>> pesquisarUsuario(@PathVariable String email){
        return ResponseEntity.ok(usuarioRepository.findByEmail(email));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editaUsuario(@RequestBody UsuarioDTO dto, @RequestParam("id") UUID id){
        UsuarioDTO usuario = usuarioService.updateUsuario(dto, id);
        return ResponseEntity.ok(usuario);
    }


}
