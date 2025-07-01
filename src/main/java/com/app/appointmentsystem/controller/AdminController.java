package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.dto.AppointmentResponseDto;
import com.app.appointmentsystem.model.Appointment;
import com.app.appointmentsystem.service.AppointmentMedicalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/admin")
@SecurityRequirement(name = "Bearer Authentication")
public class AdminController {

    private final AppointmentMedicalService appointmentMedicalService;

    public AdminController(AppointmentMedicalService appointmentMedicalService) {
        this.appointmentMedicalService = appointmentMedicalService;
    }

    @Operation( summary = "Obtener todas las citas")
    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointments() {
        return ResponseEntity.ok(appointmentMedicalService.findAll().stream()
                .map(this::convertToDto)
                .toList());
    }

    @Operation(summary = "Cancelar cita")
    @PatchMapping("/appointments/{id}/cancel")
    public ResponseEntity<AppointmentResponseDto> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(convertToDto(appointmentMedicalService.cancelAppointment(id)));
    }

    private AppointmentResponseDto convertToDto (Appointment appointment){
        return new AppointmentResponseDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStatus().name(),
                appointment.getAppUsers().getId(),
                appointment.getMedicalService().getId()
        );
    }
}
