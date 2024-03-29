package com.dev.introductiontospringboot.bean.impl;

import com.dev.introductiontospringboot.bean.SuperInterface;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class MyBeanB implements SuperInterface {
    public MyBeanB() {
        System.out.println("MyBeanB created");
    }

    @Override
    public void run() {
        System.out.println("MyBeanB is running");
    }
}