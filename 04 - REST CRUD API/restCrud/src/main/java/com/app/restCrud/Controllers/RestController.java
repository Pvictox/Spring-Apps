package com.app.restCrud.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
