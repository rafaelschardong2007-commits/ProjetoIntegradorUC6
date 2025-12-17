package com.projetointegrador.projetointegrador.service;

import com.projetointegrador.projetointegrador.model.Usuario;

public class UsuarioService {

    public boolean autenticar(Usuario usuario) {
        return usuario.getLogin().equals("admin")
            && usuario.getSenha().equals("123");
    }
}
