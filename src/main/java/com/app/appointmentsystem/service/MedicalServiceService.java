package com.app.appointmentsystem.service;

import com.app.appointmentsystem.model.Service;
import com.app.appointmentsystem.repository.ServiceRepository;

import java.util.List;

public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }
}
