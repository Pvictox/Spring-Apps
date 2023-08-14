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
			//System.out.println(retrieveStudentById(studentDAO, 400));
			///getAllStudents(studentDAO);
			//getByFirstName(studentDAO, "Pedro");
			//updateById(studentDAO, 3);
			updateLastName(studentDAO, "o");
		};
	}

	private void updateLastName(StudentDAO studentDAO, String str) {
		System.out.println("Rows affected: "+studentDAO.updateLastName(str));
	}

	private void updateById(StudentDAO studentDAO, int i) {
		studentDAO.updateStudentbyId(i);
	}

	private void getByFirstName(StudentDAO studentDAO, String firstName) {
		for (Student std:
			 studentDAO.getStudentByFirstName(firstName)) {
			System.out.println("=========\n"+std.toString()+"========\n");
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		for (Student student:
			 studentDAO.returnAllStudents()) {
			System.out.println("---------------");
			System.out.println(student.toString());
			System.out.println("---------------");
		}
	}

	private String retrieveStudentById(StudentDAO studentDAO, int id) {
		Student searchedStudent = studentDAO.getStudentbyId(id);
		return searchedStudent!=null ? searchedStudent.toString() : "Not found";
	}

	//Method created to check the auto increment feature on the database.
	private void createMultipleStudents(StudentDAO studentDAO) {
		List<String> first_names = new ArrayList<>(); first_names.add("Pedro"); first_names.add("Carlos"); first_names.add("Maria");
		List<String> sur_names = new ArrayList<>(); sur_names.add("Abreu"); sur_names.add("Silva"); sur_names.add("Ferraz");

		for (String firstName:
			 first_names) {
			System.out.println("---- Creating ----");
			studentDAO.save(new Student(firstName, sur_names.get(first_names.indexOf(firstName)), "***"));
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
