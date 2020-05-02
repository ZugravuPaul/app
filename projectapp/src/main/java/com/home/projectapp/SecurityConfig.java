package com.home.projectapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/register/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/**").hasAnyRole("ADMIN","SELLER_USER")
                .antMatchers(HttpMethod.POST, "/products/**").hasAnyRole("ADMIN","SELLER_USER")
                .antMatchers(HttpMethod.PUT, "/products/**").hasAnyRole("ADMIN","SELLER_USER")
                .antMatchers(HttpMethod.GET, "/products").permitAll()
                .and().httpBasic();
    }

    @Autowired
    public void configureADMIN(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ZPaul").password("{noop}adminpass").roles("ADMIN");
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }
    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }
}
