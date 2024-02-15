package com.dev.introductiontospringboot.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
@Lazy
public class MyBeanC implements SuperInterface{
    public MyBeanC() {
        System.out.println("MyBeanC created");
    }
    @Override
    public void run() {
        System.out.println("MyBeanC is running");
    }
}


