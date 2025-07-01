package com.app.appointmentsystem.dto;

public record MedicalServiceResponseDto(
        Long id,
        String name,
        Integer durationMinutes
) {
}
