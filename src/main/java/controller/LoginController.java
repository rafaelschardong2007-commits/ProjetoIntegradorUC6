package com.projetointegrador.projetointegrador.controller;

import com.projetointegrador.projetointegrador.dto.LoginRequest;
import com.projetointegrador.projetointegrador.model.Usuario;
import com.projetointegrador.projetointegrador.repository.UsuarioRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Optional<Usuario> usuarioOpt =
                usuarioRepository.findByUsername(request.getUsername());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        // Retorna o usuário (sem senha)
        usuario.setPassword(null);
        return ResponseEntity.ok(usuario);
    }
}
