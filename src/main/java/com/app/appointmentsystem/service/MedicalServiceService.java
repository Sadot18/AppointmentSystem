package com.app.appointmentsystem.service;

import com.app.appointmentsystem.dto.CreateMedicalServiceRequestDto;
import com.app.appointmentsystem.model.MedicalService;
import com.app.appointmentsystem.repository.MedicalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MedicalServiceService {
    private final MedicalServiceRepository medicalServiceRepository;

    public List<MedicalService> findAll() {
        return medicalServiceRepository.findAll();
    }

    public MedicalService createService(CreateMedicalServiceRequestDto dto) {
        MedicalService service = new MedicalService();
        service.setName(dto.name());
        service.setDurationMinutes(dto.durationMinutes());
        service.setPrice(dto.price());

        return medicalServiceRepository.save(service);
    }
}
