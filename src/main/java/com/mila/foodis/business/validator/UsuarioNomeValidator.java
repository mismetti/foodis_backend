package com.mila.foodis.business.validator;

import com.mila.foodis.infrastructure.entity.Usuario;
import com.mila.foodis.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class UsuarioNomeValidator implements UsuarioValidator {

    private static final Pattern SOMENTE_LETRAS = Pattern.compile("[A-z\\s]+");
    private final UsuarioRepository usuarioRepository;

    @Override
    public void validar(Usuario usuario) {
        if (!SOMENTE_LETRAS.matcher(usuario.getNome()).matches()) {
            throw new RuntimeException("Usuário deve conter somentes letras");
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Já existe um usuário com este email.");
        }
    }
}
