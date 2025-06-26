package com.app.appointmentsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;//Enum: CLIENT, ADMIN

    @OneToMany(mappedBy = "appUsers")
    private List<Appointment> appointments;
}
