package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.dto.AppointmentResponseDto;
import com.app.appointmentsystem.dto.CreateAppointmentRequestDto;
import com.app.appointmentsystem.model.Appointment;
import com.app.appointmentsystem.service.AppointmentMedicalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Citas", description = "API para gestion de citas")
@SecurityRequirement(name = "Bearer Authentication")
public class AppointmentController {

    private final AppointmentMedicalService appointmentMedicalService;

    public AppointmentController(AppointmentMedicalService appointmentMedicalService) {
        this.appointmentMedicalService = appointmentMedicalService;
    }

    @Operation( summary = "Crear nueva cita(Cliente)")
    @PostMapping
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<AppointmentResponseDto> createAppointment(
            @RequestBody @Valid CreateAppointmentRequestDto request,
            @AuthenticationPrincipal UserDetails userDetails) {

        Appointment appointment = appointmentMedicalService.create(request, userDetails.getUsername());

        return ResponseEntity.ok(new AppointmentResponseDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStatus().name(),
                appointment.getAppUsers().getId(),
                appointment.getMedicalService().getId()
        ));
    }

    @Operation(summary = "Obtener mis citas (Cliente)")
    @GetMapping("/my-appointments")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<Appointment>> getMyAppointments(
            @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();
        return ResponseEntity.ok(appointmentMedicalService.findByUserEmail(email));
    }
}