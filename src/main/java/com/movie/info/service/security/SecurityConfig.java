package com.movie.info.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // class for security configuration

    @Autowired
    private UserInformation userDetails;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // setting of Authentication Manager Builder
        auth.userDetailsService(userDetails);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Setting of Authentication filter
        http
                .authorizeRequests()
                .antMatchers("/test").permitAll()
                .antMatchers("**").authenticated()
                .and().formLogin();
    }

}
