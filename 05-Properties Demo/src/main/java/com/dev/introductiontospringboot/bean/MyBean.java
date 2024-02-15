package com.dev.introductiontospringboot.bean;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    public MyBean() {
        System.out.println("MyBean created");
    }

    public String sayHello() {
        return "Hello from MyBean";
    }
}
