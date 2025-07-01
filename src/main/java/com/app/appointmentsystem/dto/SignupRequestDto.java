package com.app.appointmentsystem.dto;

public record SignupRequestDto(
        String email,
        String password,
        String name
) {
}
