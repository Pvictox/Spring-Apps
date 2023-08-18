package com.app.restCrud.Controllers;

import com.app.restCrud.Models.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @RequestMapping(method = RequestMethod.GET, value = "/allstudents")
    public List<Student> returnAllStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Pedro", "Fonseca"));
        list.add(new Student("Maria", "Ferraz"));
        list.add(new Student("Calors", "Maia"));
        return list;
    }
}
