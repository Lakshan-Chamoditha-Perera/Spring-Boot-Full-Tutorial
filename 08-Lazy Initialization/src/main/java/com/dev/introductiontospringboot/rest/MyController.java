package com.dev.introductiontospringboot.rest;

import com.dev.introductiontospringboot.bean.SuperInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final SuperInterface myBean;

    @Value("${USERNAME}")
    private String username;
    //    add 0000 for password if not found in application.properties
    @Value("${password:0000}")
    private String password;

    {
        System.out.println("MyController created");
    }

    public MyController(@Qualifier("myBeanA") SuperInterface myBean) {
        this.myBean = myBean;
        myBean.run();
    }

    @GetMapping("/")
    public String get() {
        return ("Rest Controller is working! Username: " + username + "Password: " + password);
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
