package com.demoworkout.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Pratice fast vowling for 15 minutes";
    }
}
