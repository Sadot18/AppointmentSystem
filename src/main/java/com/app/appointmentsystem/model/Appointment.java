package com.app.appointmentsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    @Enumerated(EnumType.STRING)
    private Status status; // PENDING, CONFIRMED, CANCELLED

    @ManyToOne
    private User user;

    @ManyToOne
    private Service service;
}
