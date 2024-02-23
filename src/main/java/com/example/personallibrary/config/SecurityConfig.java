package com.example.personallibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager manager() {
        UserDetails user = User.withDefaultPasswordEncoder() // Acceptable for demos and getting started.
                .username("user")
                .password("teste")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.GET).authenticated()
                .requestMatchers(HttpMethod.POST).authenticated()
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN"))
                .csrf(csrf -> csrf.disable()) // Safe to disable when used ONLY by with non-browser clients (such as Postman)
                .httpBasic(withDefaults());

        return http.build();
    }
}