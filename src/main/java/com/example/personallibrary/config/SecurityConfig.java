package com.example.personallibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager manager(){
      UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("teste")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user); 
    } 
}