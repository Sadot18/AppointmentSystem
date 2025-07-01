package com.app.appointmentsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponseDto(
        Long id,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        String status,
        Long userId,
        Long serviceId
) {}
