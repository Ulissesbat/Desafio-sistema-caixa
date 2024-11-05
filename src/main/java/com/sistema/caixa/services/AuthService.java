package com.sistema.caixa.services;

import com.sistema.caixa.entities.Usuario;
import com.sistema.caixa.services.exception.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioService usuarioService;

    public void validationSelfOrAdmin (long userId){
        Usuario me = usuarioService.autthenticated();
        if (!me.hasRole("ROLE_ADMIN") && ! me.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
}
