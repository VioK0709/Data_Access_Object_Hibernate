package com.example.data_access_object_hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityAppImpl implements WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("Иван")
                .password("{noop}user")
                .roles("USER")
                .build());

        manager.createUser(User
                .withUsername("Николай")
                .password("{noop}admin")
                .roles("ADMIN")
                .build());

        return manager;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/hello")
                        .permitAll()
                        .anyRequest()
                        .authenticated());
    }
}