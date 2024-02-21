package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {

    //----------------------------------------------------------------------------------------------------
    //create pointcut include package .. exclude getter/setter
    @Pointcut("(forDaoPackages()&&!(forGetMethods()||forSetMethods()))")
    private void forDaoPackage() {
    }

    //----------------------------------------------------------------------------------------------------
    //    point cut for all add methods of void return type with Account param in impl package
    @Pointcut("execution(void add*(com.springboot.aopdemo.entity.Account))")
    private void forAddMethodsWithAccountParam() {
    }

    @Before("forAddMethodsWithAccountParam()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> beforeAddAccountAdvice Executing @Before advice on addAccount()");
    }

    @Before("forAddMethodsWithAccountParam()")
    public void performCloseConnections() {
        System.out.println("\n=====>>> performCloseConnections: Executing @Before advice on addAccount()");
    }

    //----------------------------------------------------------------------------------------------------
    //    point cut for all get methods of any return type in impl package
    @Pointcut("execution(* com.springboot.aopdemo.dao.impl.*.get*(..))")
    private void forGetMethods() {
    }

    @Before("forGetMethods()")
    public void beforeGetAccountAdvice() {
        System.out.println("\n=====>>> beforeGetAccountAdvice: Executing @Before advice in com.springboot.aopdemo.dao.get*()");
    }

    //----------------------------------------------------------------------------------------------------
    //    point cut for all set methods of any return type in impl package
    @Pointcut("execution(* com.springboot.aopdemo.dao.impl.*.set*(..))")
    private void forSetMethods() {
    }

    //----------------------------------------------------------------------------------------------------
    @Before("execution(void api*())")
    public void beforeAPIAnalytics() {
        System.out.println("\n=====>>> Executing @Before advice on apiTest()");
    }
}

//what is an aspect?
//a class that contains advice

//what is advice?
//code that we want to run before or after a method