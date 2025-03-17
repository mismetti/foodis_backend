package com.mila.foodis.business.validator;

import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioEmailValidator implements UsuarioValidator{

    private final UsuarioRepository usuarioRepository;
    @Override
    public void validar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail())
                .filter(usuarioEncontrado -> usuario.getId().equals(usuarioEncontrado.getId()))
                .isEmpty()){
            throw new RuntimeException("Já existe um usuário com este email.");
        }
    }
}
