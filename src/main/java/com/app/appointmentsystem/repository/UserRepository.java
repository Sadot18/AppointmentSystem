package com.app.appointmentsystem.repository;

import com.app.appointmentsystem.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUsers, Long> {
    Optional<AppUsers> findByEmail(String email);//Para buscar usuarios por email
    boolean existsByEmail(String email);
}
