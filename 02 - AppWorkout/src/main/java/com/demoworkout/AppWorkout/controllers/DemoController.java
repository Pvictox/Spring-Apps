package com.demoworkout.AppWorkout.controllers;

import com.demoworkout.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    /*@Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }
*/
    @Autowired
    public void setCoach(Coach newCoach){
        myCoach = newCoach;
    }
    //Endpoint '/' to check the functionality of the app
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloMessage(){
        return "Welcome to our App";
    }

    //Endpoint '/daily to check the daily workout from the object 'myCoach'
    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String dailyWorkoutEndpoint(){
        return "This is your daily workout: "+myCoach.getDailyWorkout();
    }


}
