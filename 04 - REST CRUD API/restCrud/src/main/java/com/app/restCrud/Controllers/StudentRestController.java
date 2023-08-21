package com.app.restCrud.Controllers;

import com.app.restCrud.Models.Student;
import com.app.restCrud.Models.StudentCustomExceptions;
import com.app.restCrud.Models.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students/")
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
        if (studentId < 0 || studentId > listStudent.size()){
            throw new StudentNotFoundException("Student - "+studentId+" not found");
        }
        return listStudent.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentCustomExceptions> handleException(StudentNotFoundException ex){
        StudentCustomExceptions studentEx = new StudentCustomExceptions();
        studentEx.setStatus(HttpStatus.NOT_FOUND.value()); //404
        studentEx.setMessage(ex.getMessage());
        studentEx.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentEx, HttpStatus.NOT_FOUND);
    }

}
