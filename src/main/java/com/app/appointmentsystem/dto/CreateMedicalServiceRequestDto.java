package com.app.appointmentsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record CreateMedicalServiceRequest(
        @NotBlank String name,
        @Min(1) Integer durationMinutes,
        @Positive Double price
) {
}
