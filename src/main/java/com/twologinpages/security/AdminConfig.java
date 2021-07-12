package com.twologinpages.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Order(2)
@EnableWebSecurity
public class AdminConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("adminDetail")
    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .antMatcher("/admin/**")
                .authorizeRequests()
                .antMatchers("/admin/adminPage").hasRole("ADMIN")
                .antMatchers("/admin/loginAdmin").anonymous()
                .anyRequest()
                .authenticated()

                .and()
                .formLogin()
                .loginPage("/admin/loginAdmin")
                .loginProcessingUrl("/admin/admin_login")
                .defaultSuccessUrl("/admin/adminPage")
                .failureUrl("/admin/loginAdmin")

                .and()
                .logout()
                .logoutUrl("/admin/admin_logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")

                .invalidateHttpSession(true);


    }


}