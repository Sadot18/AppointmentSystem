package com.app.appointmentsystem.repository;

import com.app.appointmentsystem.model.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalServiceRepository extends JpaRepository<MedicalService, Long> {

}
