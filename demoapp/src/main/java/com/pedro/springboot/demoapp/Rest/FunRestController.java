package com.pedro.springboot.demoapp.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Set as a Rest Controller using @RestController annotation.
@RestController
public class FunRestController {

    //Using Injection we can retrieve some info that was set on 'application.properties' file.
    @Value("${coach.name}") //This annotation retrieves the info from the properties file
    private String coachName;

    //@GetMapping it's a shortcut for @RequestMapping (method = RequestMethod.GET)
    // Using an endpoint '/' who will return the message "Hello World"

   /* @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHelloAgain(){
        return "Hello World using RequestMapping. Done by: "+this.coachName;
    }
}
