package com.example.data_access_object_hibernate.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSecurityConfigurerAdapter {

    void configure(HttpSecurity httpSecurity) throws Exception;
}
