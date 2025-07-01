package com.app.appointmentsystem.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateAppointmentRequest(
        @NotNull LocalDate date,
        @NotNull LocalTime startTime,
        @NotNull Long serviceId
        ) {
}
