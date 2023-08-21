package com.app.restCrud.Models;

//This class represents the case where a student cannot be found in the data.
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
