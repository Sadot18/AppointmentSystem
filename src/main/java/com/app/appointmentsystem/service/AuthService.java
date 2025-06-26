package com.app.appointmentsystem.service;

import com.app.appointmentsystem.config.JwtUtil;
import com.app.appointmentsystem.dto.LoginRequest;
import com.app.appointmentsystem.dto.LoginResponse;
import com.app.appointmentsystem.dto.SignupRequest;
import com.app.appointmentsystem.model.Role;
import com.app.appointmentsystem.model.AppUsers;
import com.app.appointmentsystem.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public void registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("El email ya está registrado");
        }

        AppUsers appUsers = new AppUsers();
        appUsers.setEmail(request.email());
        appUsers.setPassword(passwordEncoder.encode(request.password())); // ¡Contraseña hasheada!
        appUsers.setRole(Role.CLIENT); // Asigna rol por defecto

        userRepository.save(appUsers);
    }

    public LoginResponse authenticate(LoginRequest request) {
        // Autenticar usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        // Generar token JWT
        String token = jwtUtil.generateToken(request.email());
        return new LoginResponse(token);
    }
}