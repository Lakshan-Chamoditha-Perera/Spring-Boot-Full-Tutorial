package com.dev.introductiontospringboot.bean.impl;

import com.dev.introductiontospringboot.bean.SuperInterface;
import org.springframework.stereotype.Component;

//providing a custom name to the bean
@Component("MY_BEAN")
public class MyBean implements SuperInterface {
    public MyBean() {
        System.out.println("Constructor called");
    }

    @Override
    public void getDailyWorkout() {
        System.out.println("MyBean is running");
    }
}

