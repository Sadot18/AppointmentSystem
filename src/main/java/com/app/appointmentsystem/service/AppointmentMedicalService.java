package com.app.appointmentsystem.service;

import com.app.appointmentsystem.dto.CreateAppointmentRequestDto;
import com.app.appointmentsystem.model.AppUsers;
import com.app.appointmentsystem.model.Appointment;
import com.app.appointmentsystem.model.MedicalService;
import com.app.appointmentsystem.model.Status;
import com.app.appointmentsystem.repository.AppointmentRepository;
import com.app.appointmentsystem.repository.MedicalServiceRepository;
import com.app.appointmentsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentMedicalService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository usersRepository;
    private final MedicalServiceRepository medicalServiceRepository;

    @Transactional
    public Appointment create(CreateAppointmentRequestDto request, String userEmail) {
        AppUsers user = usersRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        MedicalService medicalService = medicalServiceRepository.findById(request.serviceId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        Appointment appointment = new Appointment();
        appointment.setDate(request.date());
        appointment.setStartTime(request.startTime());
        appointment.setEndTime(request.startTime().plusMinutes(medicalService.getDurationMinutes()));
        appointment.setStatus(Status.PENDING);
        appointment.setAppUsers(user);
        appointment.setMedicalService(medicalService);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findByUserEmail(String email) {
        return appointmentRepository.findByAppUsersEmail(email);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment cancelAppointment(Long id) {
        return null;
    }
}