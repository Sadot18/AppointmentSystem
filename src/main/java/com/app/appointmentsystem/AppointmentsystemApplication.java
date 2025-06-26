package com.app.appointmentsystem;

import com.app.appointmentsystem.model.Role;
import com.app.appointmentsystem.model.AppUsers;
import com.app.appointmentsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class AppointmentsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentsystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			AppUsers admin = new AppUsers();
			admin.setEmail("admin@example.com");
			admin.setName("Administrador");
			admin.setPassword(passwordEncoder.encode("admin123"));
			admin.setRole(Role.ADMIN);


			AppUsers client = new AppUsers();
			client.setEmail("client@example.com");
			client.setName("Cliente Demo");
			client.setPassword(passwordEncoder.encode("client123"));
			client.setRole(Role.CLIENT);

			userRepository.saveAll(List.of(admin, client));
		};
	}
}
