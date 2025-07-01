package com.app.appointmentsystem.controller;

import com.app.appointmentsystem.dto.CreateMedicalServiceRequestDto;
import com.app.appointmentsystem.dto.MedicalServiceResponseDto;
import com.app.appointmentsystem.model.MedicalService;
import com.app.appointmentsystem.service.MedicalServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services-medicos")
@Tag(name = "Servicios Medicos", description = "Gestión de servicios médicos")
public class MedicalServiceController {

    private final MedicalServiceService medicalServiceService;

    public MedicalServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @Operation(summary = "Listar todos los servicios")
    @GetMapping
    public ResponseEntity<List<MedicalService>> getAllServices() {
        return ResponseEntity.ok(medicalServiceService.findAll());
    }

    @Operation(summary = "Crear servicio (Admin)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MedicalServiceResponseDto> createService(
            @RequestBody @Valid CreateMedicalServiceRequestDto dto) {
        MedicalService service = medicalServiceService.createService(dto);
        return ResponseEntity.ok(new MedicalServiceResponseDto(
                service.getId(),
                service.getName(),
                service.getDurationMinutes()
        ));
    }
}