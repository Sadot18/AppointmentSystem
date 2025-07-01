package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.dto.LoginRequestDto;
import com.app.appointmentsystem.dto.LoginResponseDto;
import com.app.appointmentsystem.dto.SignupRequestDto;
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

    @Operation(summary = "Login de usuario")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @Operation(summary = "Registro de usuario")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto request) {
        authService.registerUser(request);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}