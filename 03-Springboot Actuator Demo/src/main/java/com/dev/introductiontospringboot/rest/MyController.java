package com.dev.introductiontospringboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public void get() {
        System.out.println("Rest Controller is working!");
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
