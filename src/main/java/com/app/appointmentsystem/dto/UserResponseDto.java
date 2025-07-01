package com.app.appointmentsystem.dto;

import com.app.appointmentsystem.model.Role;

public record UserResponseDto(
        Long id,
        String email,
        String name,
        Role role
) {
}
