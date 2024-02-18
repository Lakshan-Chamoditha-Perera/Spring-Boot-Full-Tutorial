package com.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("shan")
                .password("{noop}1234")
                .roles("USER")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}manager")
                .roles("MANAGER", "USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN", "MANAGER", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin, manager);
    }

}
