package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.model.Appointment;
import com.app.appointmentsystem.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Citas", description = "API para gestion de citas")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @Operation(summary = "Crear cita", description = "Requiere autenticación (rol CLIENT)")
    @PreAuthorize("hasRole('CLIENT')")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }
}