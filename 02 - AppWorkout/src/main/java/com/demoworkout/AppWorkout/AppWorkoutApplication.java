package com.demoworkout.AppWorkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.demoworkout.AppWorkout",
		"com.demoworkout.util",
		"com.demoworkout.configClasses"}
)
public class AppWorkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWorkoutApplication.class, args);
	}

}
