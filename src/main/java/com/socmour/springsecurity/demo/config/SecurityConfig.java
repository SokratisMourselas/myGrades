package com.socmour.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // in memory authentication

        UserBuilder userBinder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBinder.username("John").password("test123").roles("EMPLOYEE"))
                .withUser(userBinder.username("Mary").password("test123").roles("MANAGER"))
                .withUser(userBinder.username("Mark").password("test123").roles("ADMIN"))
        ;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showLoginForm")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll();
    }
}
