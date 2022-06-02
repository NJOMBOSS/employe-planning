package com.employe.planningemploye;


import com.employe.planningemploye.domain.Competence;
import com.employe.planningemploye.domain.Employe;
import com.employe.planningemploye.domain.Horaire;
import com.employe.planningemploye.domain.Service;
import com.employe.planningemploye.persistence.CompetenceRepository;
import com.employe.planningemploye.persistence.EmployeRepository;
import com.employe.planningemploye.persistence.HoraireRepository;
import com.employe.planningemploye.persistence.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.time.LocalTime;

@SpringBootApplication
public class PlanningEmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanningEmployeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(HoraireRepository horaireRepository, ServiceRepository serviceRepository,
							EmployeRepository employeRepository, CompetenceRepository competenceRepository){
		return args->{

			Service s1 = serviceRepository.save(new Service("Informatique"));
			Service s2 = serviceRepository.save(new Service("Comptable"));
			Service s3 = serviceRepository.save(new Service("Marketing"));
			Service s4 = serviceRepository.save(new Service("RH"));

			Horaire h1 = horaireRepository.save(new Horaire(DayOfWeek.MONDAY, LocalTime.of(6,00), LocalTime.of(12,00)));
			Horaire h2 = horaireRepository.save(new Horaire(DayOfWeek.MONDAY, LocalTime.of(12,00), LocalTime.of(18,00)));
			Horaire h3 = horaireRepository.save(new Horaire(DayOfWeek.MONDAY, LocalTime.of(18,00), LocalTime.of(00,00)));
			Horaire h4 = horaireRepository.save(new Horaire(DayOfWeek.MONDAY, LocalTime.of(00,00), LocalTime.of(6,00)));

			Competence c1 = competenceRepository.save(new Competence("Développeur"));
			Competence c2 = competenceRepository.save(new Competence("Designeur"));
			Competence c3 = competenceRepository.save(new Competence("Cyber sécurité"));
			Competence c4 = competenceRepository.save(new Competence("Manager"));

			Employe e1 = employeRepository.save(new Employe(null, "FONKE", "Eric", s1, h4,c3));
			Employe e2 = employeRepository.save(new Employe(null, "FOKO", "Junior", s3, h1,c1));
			Employe e3 = employeRepository.save(new Employe(null, "JEAN", "Jacques", s2, h3,c4));
			Employe e4 = employeRepository.save(new Employe(null, "KAMDEM", "Yannick", s4, h2,c2 ));

		};
	}
}
