package com.mila.foodis.business.service;

import com.mila.foodis.business.converter.UsuarioConverter;
import com.mila.foodis.business.dto.UsuarioDTO;
import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO updateUsuario(UsuarioDTO dto, UUID id){
        try{
            Usuario entity = usuarioRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Não foi possível encontrar o Id."));
            Usuario usuario = usuarioConverter.atualizaUsuario(dto, entity);
            return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

        }catch (RuntimeException e){
            throw new RuntimeException("Não foi possivel atualizar estes dados.", e);
        }
    }

}
