package com.thoughtmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication /* Entry point for the Spring Boot service */
@RestController /* Expose the code in this class as a Spring RestController class */
@RequestMapping(value="hello") /*/hello es the prefix of all URLs exposed in this application */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
    /* GET-based REST endpoint with two parameters */
    public String hello( @PathVariable("firstName") String firstName,
                         @PathVariable("lastName") String lastName) {
    	/* Maps parameters in the URL to variables */
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
        /* Returns simple JSON string */
    }
}
