package com.app.restCrud.Models;

//This class will be responsible to represent the model of response that will be sent
//to the rest client in case of some error
public class StudentCustomExceptions {
    private int status; //Status of the exception eg: 404, 500...
    private String message; //Eg: Student not found.
    private Long timeStamp; //Time when that exception occurred.

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
