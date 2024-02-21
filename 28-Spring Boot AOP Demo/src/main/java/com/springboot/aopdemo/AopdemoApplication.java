package com.springboot.aopdemo;

import com.springboot.aopdemo.dao.AccountDAO;
import com.springboot.aopdemo.dao.MembershipDAO;
import com.springboot.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {

//			demoTheBeforeAdvice(accountDAO,membershipDAO);
//            demoTheAfterReturningAdvice(accountDAO);
//            accountDAO.apiTest();
//
//            accountDAO.setServiceCode("silver");
//            accountDAO.setName("lakshan");
//
            String name = accountDAO.getName();
            String serviceCode = accountDAO.getServiceCode();


        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount();
        membershipDAO.addAccount();
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        accountDAO.addAccount(new Account());
    }

}
