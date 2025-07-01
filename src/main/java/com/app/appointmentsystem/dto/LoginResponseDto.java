package com.app.appointmentsystem.dto;

public record LoginResponse(
        String token,
        String email,
        com.app.appointmentsystem.model.Role role
) {
}
