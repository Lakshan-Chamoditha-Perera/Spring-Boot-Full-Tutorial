package com.springboot.mvcwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        UserDetails john = User.builder()
                .username("user")
                .password("{noop}1234")
                .roles("EMPLOYEE").build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANAGER").build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}1234")
                .roles("ADMIN","MANAGER","EMPLOYEE").build();

        inMemoryUserDetailsManager.createUser(john);
        inMemoryUserDetailsManager.createUser(mary);
        inMemoryUserDetailsManager.createUser(susan);

        return inMemoryUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/manager/**").hasRole("MANAGER")
                        .requestMatchers("/system/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(
                        logout->
                                logout.permitAll()
                );
        return http.build();
    }


}
