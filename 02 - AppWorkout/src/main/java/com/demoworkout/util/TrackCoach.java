package com.demoworkout.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.sound.midi.Track;

@Component

public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("Class Name: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Runa a hard 5k!";
    }
}
