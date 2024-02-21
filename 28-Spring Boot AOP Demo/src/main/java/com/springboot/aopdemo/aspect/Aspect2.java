package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class Aspect2 {
    @Before("execution(* com.springboot.aopdemo.api.*.apiTest())")
    public void beforeAPIAnalytics() {
        System.out.println("\n=====>>>IN Aspect 2 : Executing @Before advice on apiTest()");
    }
}
