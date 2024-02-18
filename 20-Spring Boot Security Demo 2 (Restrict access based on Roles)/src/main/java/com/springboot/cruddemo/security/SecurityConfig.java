package com.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("shan")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}manager")
                .roles("MANAGER", "EMPLOYEE")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN", "MANAGER", "EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(user, admin, manager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees").hasRole("ADMIN")
        );
        // use HTTP basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        // disable CSRF. In general, it is not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH methods
        httpSecurity.csrf(csrf->csrf.disable());
        return httpSecurity.build();
    }
}





