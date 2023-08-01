package com.pedro.springboot.demoapp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Set as a Rest Controller using @RestController annotation.
@RestController
public class FunRestController {
    //@GetMapping it's a shortcut for @RequestMapping (method = RequestMethod.GET)

    // Using an endpoint '/' who will return the message "Hello World"

   /* @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHelloAgain(){
        return "Hello World using RequestMapping";
    }
}
