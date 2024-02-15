package com.dev.introductiontospringboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${USERNAME}")
    private String username;

    //    add 0000 for password if not found in application.properties
    @Value("${password:0000}")
    private String password;


    @GetMapping("/")
    public String get() {
        return ("Rest Controller is working! Username: " + username + "Password: " + password);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello endpoint is working!";
    }

    //    expose a new endpoint for /work
    @GetMapping("/work")
    public String work() {
        return "Work endpoint is working!";
    }
}
