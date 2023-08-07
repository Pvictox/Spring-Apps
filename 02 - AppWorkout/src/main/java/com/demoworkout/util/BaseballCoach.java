package com.demoworkout.util;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    /*public BaseballCoach(){
        System.out.println("Class Name: "+getClass().getSimpleName());
    }*/
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in a batting practice";
    }
}
