package com.demoworkout.AppWorkout.controllers;

import com.demoworkout.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach friendsCoach;

    /*@Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("Class Name: "+getClass().getSimpleName());
        myCoach = theCoach;
    }*/

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach){
        myCoach = theCoach;
        friendsCoach = anotherCoach;
    }


    /* @Autowired
    public void setCoach(Coach newCoach){
        myCoach = newCoach;
    }*/


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

    //Create endpoint '/check' to check if the attribute 'myCoach' is the same as 'friendsCoach'
    //This method was created to check how the scope of beans in spring works.

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String checkBean(){
        //If scope of the bean == Singleton then the result will be TRUE
        //If scope of the bean == Prototype then the result will be False
        return "myCoach equals as friendsCoach: "+ (myCoach==friendsCoach);
    }


}
