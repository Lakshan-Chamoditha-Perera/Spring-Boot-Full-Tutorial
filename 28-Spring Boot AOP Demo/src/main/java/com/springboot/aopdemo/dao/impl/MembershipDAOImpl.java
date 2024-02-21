package com.springboot.aopdemo.dao.impl;

import com.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }
}
