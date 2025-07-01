package com.app.appointmentsystem.dto;

public record LoginResponseDto(
        String token,
        String email,
        com.app.appointmentsystem.model.Role role
) {
}
