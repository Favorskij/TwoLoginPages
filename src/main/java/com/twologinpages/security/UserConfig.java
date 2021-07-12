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

@Order(1)
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("userDetail")
    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/user/**")
                .authorizeRequests()
                .antMatchers("/user/userPage").hasAnyRole("USER","ADMIN")
                .antMatchers("/user/loginUser").anonymous()
                .anyRequest()
                .authenticated()

                .and()
                .formLogin()
                .loginPage("/user/loginUser")
                .loginProcessingUrl("/user/user_login")
                .defaultSuccessUrl("/user/userPage")
                .failureUrl("/user/loginUser")

                .and()
                .logout()
                .logoutUrl("/user/user_logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")

                .invalidateHttpSession(true);

    }

}