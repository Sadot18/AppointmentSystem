package com.app.appointmentsystem.service;

import com.app.appointmentsystem.dto.CreateAppointmentRequest;
import com.app.appointmentsystem.model.AppUsers;
import com.app.appointmentsystem.model.Appointment;
import com.app.appointmentsystem.model.Status;
import com.app.appointmentsystem.repository.AppointmentRepository;
import com.app.appointmentsystem.repository.ServiceRepository;
import com.app.appointmentsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository usersRepository;
    private final ServiceRepository serviceRepository;

    @Transactional
    public Appointment create(CreateAppointmentRequest request, String userEmail) {
        AppUsers user = usersRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Service service = serviceRepository.findById(request.serviceId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        Appointment appointment = new Appointment();
        appointment.setDate(request.date());
        appointment.setStartTime(request.startTime());
        appointment.setEndTime(request.startTime().plusMinutes(service.getDurationMinutes()));
        appointment.setStatus(Status.PENDING);
        appointment.setAppUsers(user);
        appointment.setService(service);

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