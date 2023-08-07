package com.demoworkout.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jdk.jfr.Label;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)  //Set scope to Singleton = Only one instance of the class
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    /*public CricketCoach(){
        System.out.println("Class Name: "+getClass().getSimpleName());
    }*/
    @Override
    public String getDailyWorkout() {
        return "Pratice fast vowling for 15 minutes";
    }

    @PostConstruct
    public void myStartCode(){
        System.out.println("Hey, I'm doing something on my start: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void myDestroyCode(){
        System.out.println("Hey, I'm gonna do some stuff before shutting down: "+getClass().getSimpleName());
    }
}
