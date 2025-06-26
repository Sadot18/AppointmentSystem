package com.app.appointmentsystem.repository;

import com.app.appointmentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);//Para buscar usuarios por email

}
