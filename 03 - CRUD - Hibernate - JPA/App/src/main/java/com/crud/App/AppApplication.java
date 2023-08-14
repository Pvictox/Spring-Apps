package com.crud.App;

import com.crud.App.dao.StudentDAO;
import com.crud.App.dao.StudentDAOImp;
import com.crud.App.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createNewStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			System.out.println(retrieveStudentById(studentDAO, 400));
		};
	}

	private String retrieveStudentById(StudentDAO studentDAO, int id) {
		Student searchedStudent = studentDAO.getStudentbyId(id);
		return searchedStudent!=null ? searchedStudent.toString() : "Não encontrado";
	}

	//Method created to check the auto increment feature on the database.
	private void createMultipleStudents(StudentDAO studentDAO) {
		List<String> nomes = new ArrayList<>(); nomes.add("Pedro"); nomes.add("Carlos"); nomes.add("Maria");
		List<String> sobrenomes = new ArrayList<>(); sobrenomes.add("Abreu"); sobrenomes.add("Silva"); sobrenomes.add("Ferraz");

		for (String firstName:
			 nomes) {
			System.out.println("---- Creating ----");
			studentDAO.save(new Student(firstName, sobrenomes.get(nomes.indexOf(firstName)), "***"));
			System.out.println("---- Saving ----");
		}

	}

	private void createNewStudent(StudentDAO studentDAO){
		System.out.println("---- Creating ----");
		Student newStudent = new Student("Pedro", "Fonseca", "pedro@gmail.com");;
		System.out.println("---- Saving ----");
		studentDAO.save(newStudent);
		System.out.println("Data saved: " + newStudent.getId());

	}

}
