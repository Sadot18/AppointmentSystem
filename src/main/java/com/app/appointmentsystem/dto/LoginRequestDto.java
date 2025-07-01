package com.app.appointmentsystem.dto;

public record LoginRequest(
        String email,
        String password
) {}
