package com.app.restCrud.Controllers;

import com.app.restCrud.Models.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> listStudent;

    @PostConstruct
    public void loadData(){
        listStudent = new ArrayList<>();
        listStudent.add(new Student("Pedro", "Fonseca"));
        listStudent.add(new Student("Maria", "Ferraz"));
        listStudent.add(new Student("Calors", "Maia"));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/allstudents")
    public List<Student> returnAllStudents(){
        return listStudent;
    }

    //Add endpoint /api/{studentId} where it will return the student with that ID.
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int studentId){
        return listStudent.get(studentId);
    }
}
