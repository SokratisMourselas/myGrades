package com.socmour.springsecurity.demo.config.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        // use jdbc authentication ... oh yeah!!!
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()  // allow public access to home page
                .antMatchers("/employees").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/showLoginForm")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }
}
