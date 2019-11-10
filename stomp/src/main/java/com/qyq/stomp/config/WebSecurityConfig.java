package com.qyq.stomp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("qyq").roles("user").password("$2a$10$7o35Qc.A1jo6FJmj8M8jFeEGea1s.htUwVuuWSVxw7/LW1depsRlO")
                .and()
                .withUser("yxy").roles("user").password("$2a$10$4pVILaaNEJKuQeid.FUWqeZxqoopvzAh/l6BZGOAPGbwCoVgGa9Wq");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
