package com.mila.foodis.business.validator;

import com.mila.foodis.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioSenhaValidator implements UsuarioValidator {

    @Override
    public void validar(Usuario usuario) {
        String senha = usuario.getSenha();

        if (senha.length() <= 8 || senha.length() > 64) {
            throw new RuntimeException("Tamanho da senha deve estar entre 8 e 64");
        }
    }
}
