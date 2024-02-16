package com.dev.introductiontospringboot.bean.impl;

import com.dev.introductiontospringboot.bean.SuperInterface;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements SuperInterface, InitializingBean, DisposableBean {

    public MyBean() {
        System.out.println("MyBean: Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("MyBean: PostConstruct called");
    }

    @Override
    public void run() {
        System.out.println("MyBean is running");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean: AfterPropertiesSet called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MyBean: PreDestroy called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyBean: Destroy called");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyBean: Finalize called");
    }
}
