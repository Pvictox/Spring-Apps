package com.demoworkout.configClasses;

import com.demoworkout.util.Coach;
import com.demoworkout.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class coachConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
