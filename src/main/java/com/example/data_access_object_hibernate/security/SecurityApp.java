package com.example.data_access_object_hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityApp {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("Иван")
                .password("{noop}user")
                .roles("READ")
                .build());

        manager.createUser(User
                .withUsername("Николай")
                .password("{noop}admin")
                .roles("READ", "WRITE")
                .build());

        manager.createUser(User
                .withUsername("Каземир")
                .password("{noop}user2")
                .roles("DELETE")
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/hello")
                        .permitAll()
                        .anyRequest()
                        .authenticated());
        return null;
    }
}