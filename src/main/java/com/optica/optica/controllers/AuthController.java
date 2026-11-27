package com.optica.optica.controllers;

import com.optica.optica.models.Usuario;
import com.optica.optica.repositories.UsuarioRepository;
import com.optica.optica.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario datos) {
        Usuario usuario = usuarioRepository.findByUsuario(datos.getUsuario());
        if (usuario == null || !passwordEncoder.matches(datos.getContrasena(), usuario.getContrasena())) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
        return ResponseEntity.ok(jwtUtil.generar(usuario.getUsuario()));
    }
}
