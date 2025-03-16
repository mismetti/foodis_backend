package com.mila.foodis.business.service;

import com.mila.foodis.business.converter.UsuarioConverter;
import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.business.validator.UsuarioValidator;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final List<UsuarioValidator> validators;

    public UsuarioDTO updateUsuario(UsuarioDTO dto, String id) {
        try {
            Usuario entity = usuarioRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Não foi possível encontrar o Id."));
            Usuario usuario = usuarioConverter.atualizaUsuario(dto, entity);
            validators.forEach(validator -> validator.validar(usuario));
            return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possivel atualizar estes dados.", e);
        }
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) { //Function<UsuarioDTO, UsuarioDTO>
        Usuario usuario = usuarioConverter.paraUsuario(dto);
        usuario.setDataCriacao(LocalDateTime.now());

        validators.forEach(validator -> validator.validar(usuario));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioConverter.paraUsuarioDTO(usuarioSalvo);
    }

    public void removerUsuario(String id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não existe.");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(usuario -> usuarioConverter.paraUsuarioDTO(usuario))
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}
