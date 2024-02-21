package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class Aspect3 {
    @Before("execution(* com.springboot.aopdemo.api.*.apiTest())")
    public void beforeAPIAnalytics() {
        System.out.println("\n=====>>>IN Aspect 3 : Executing @Before advice on apiTest()");
    }
}
