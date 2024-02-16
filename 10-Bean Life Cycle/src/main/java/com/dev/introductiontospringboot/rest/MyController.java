package com.dev.introductiontospringboot.rest;

import com.dev.introductiontospringboot.bean.SuperInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final SuperInterface myBeanA_1;

    public MyController(SuperInterface myBeanA_1) {
        this.myBeanA_1 = myBeanA_1;
    }

    @GetMapping("/")
    public String get() {
        return ("Rest Controller is working! ");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello endpoint is working!";
    }

    @GetMapping("/work")
    public String work() {
        return "Work endpoint is working!";
    }

}
