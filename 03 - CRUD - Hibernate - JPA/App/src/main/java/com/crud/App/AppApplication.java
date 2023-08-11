package com.crud.App;

import com.crud.App.dao.StudentDAO;
import com.crud.App.dao.StudentDAOImp;
import com.crud.App.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createNewStudent(studentDAO);
		};
	}

	private void createNewStudent(StudentDAO studentDAO){
		System.out.println("---- Creating ----");
		Student newStudent = new Student("Pedro", "Fonseca", "pedro@gmail.com");;
		System.out.println("---- Saving ----");
		studentDAO.save(newStudent);
		System.out.println("Data saved: " + newStudent.getId());

	}

}
