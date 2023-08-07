package com.demoworkout.util;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Runa a hard 5k!";
    }
}
