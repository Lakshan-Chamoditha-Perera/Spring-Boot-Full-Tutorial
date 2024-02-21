package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();

    void addAccount(Account account);

    void apiTest();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
}

