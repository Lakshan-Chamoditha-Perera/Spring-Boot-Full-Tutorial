package com.springboot.aopdemo.dao.impl;

import com.springboot.aopdemo.dao.AccountDAO;
import com.springboot.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH ACCOUNT OBJECT");
    }

    @Override
    public void apiTest() {
        System.out.println(getClass() + ": in apiTest()");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("John", "Silver"),
                new Account("Madhu", "Platinum"),
                new Account("Luca", "Gold"),
                new Account("Michele", "Diamond"),
                new Account("Michele", "Diamond")
        );
    }
}
