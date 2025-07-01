package com.app.appointmentsystem.repository;

import com.app.appointmentsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppUsersId(Long userId); // Busca por el ID del AppUsers relacionado

    List<Appointment> findByAppUsersEmail(String email);
}
