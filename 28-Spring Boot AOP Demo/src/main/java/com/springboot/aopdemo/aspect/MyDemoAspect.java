package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {
    @Before("execution(public void com.springboot.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}

//what is an aspect?
//a class that contains advice

//what is advice?
//code that we want to run before or after a method