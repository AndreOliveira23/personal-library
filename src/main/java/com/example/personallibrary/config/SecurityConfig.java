package com.example.personallibrary.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

        @Bean
        @ConditionalOnMissingBean(UserDetailsService.class)
        public UserDetailsService users() {
            UserDetails user = User.builder()
                    .username("user")
                    .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password"))
                    .roles("USER")
                    .build();
            UserDetails admin = User.builder()
                    .username("admin")
                    .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("passwd"))
                    .roles("USER", "ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user, admin);
        }

        @Bean
        @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
        DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
            return new DefaultAuthenticationEventPublisher(delegate);
        }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.GET).authenticated()
                .requestMatchers(HttpMethod.POST).authenticated()
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN"))
                .csrf(AbstractHttpConfigurer::disable) // Safe to disable when used ONLY by with non-browser clients (such as Postman)
                .httpBasic(withDefaults());

        return http.build();
    }
}