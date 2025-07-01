package com.app.appointmentsystem.repository;

import com.app.appointmentsystem.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
