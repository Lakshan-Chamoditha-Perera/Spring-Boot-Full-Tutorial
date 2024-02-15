package com.dev.introductiontospringboot.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBeanB implements SuperInterface{
    @Override
    public void run() {
        System.out.println("MyBeanB is running");
    }
}



