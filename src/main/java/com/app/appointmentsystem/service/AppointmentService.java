package com.app.appointmentsystem.service;

import com.app.appointmentsystem.model.Appointment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private static final Logger logger = LogManager.getLogger(AppointmentService.class);

    public void createAppointment() {
        logger.debug("Debug: Creando cita...");
        logger.info("Info: Cita creada exitosamente!");
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointment;
    }
}