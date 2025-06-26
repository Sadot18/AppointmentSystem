package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.dto.LoginRequest;
import com.app.appointmentsystem.dto.LoginResponse;
import com.app.appointmentsystem.dto.SignupRequest;
import com.app.appointmentsystem.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "API para login de usuarios")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    @Operation(summary = "Registrar nuevo usuario")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        authService.registerUser(request);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesion", description = "Devuelve un token JWT valido")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.authenticate(request);
    }
}