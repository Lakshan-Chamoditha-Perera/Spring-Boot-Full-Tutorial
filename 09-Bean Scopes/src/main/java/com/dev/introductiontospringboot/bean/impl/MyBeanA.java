package com.dev.introductiontospringboot.bean.impl;

import com.dev.introductiontospringboot.bean.SuperInterface;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyBeanA implements SuperInterface {
    public MyBeanA() {
        System.out.println("MyBeanA created");
    }

    @Override
    public void run() {
        System.out.println("MyBeanA is running");
    }
}
