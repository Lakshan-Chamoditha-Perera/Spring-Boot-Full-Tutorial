package com.dev.introductiontospringboot.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MyBeanA implements SuperInterface {
    public MyBeanA() {
        System.out.println("MyBeanA created");
    }

    public String sayHello() {
        return "Hello from MyBean";
    }

    @Override
    public void run() {
        System.out.println("MyBeanA is running");
    }
}
