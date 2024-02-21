package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {

    @Pointcut("execution(void add*(com.springboot.aopdemo.entity.Account))")
    private void forAddMethdsWithAccountParam() {
    }


    @Before("forAddMethdsWithAccountParam()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> beforeAddAccountAdvice Executing @Before advice on addAccount()");
    }

    @Before("forAddMethdsWithAccountParam()")
    public void performCloseConnections() {
        System.out.println("\n=====>>> performCloseConnections: Executing @Before advice on addAccount()");
    }

    //-----------------------------------------------------------------------------------
    @Before("execution(void api*())")
    public void beforeAPIAnalytics() {
        System.out.println("\n=====>>> Executing @Before advice on apiTest()");
    }
}

//what is an aspect?
//a class that contains advice

//what is advice?
//code that we want to run before or after a method