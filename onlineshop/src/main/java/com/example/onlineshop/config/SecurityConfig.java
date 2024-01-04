package com.example.onlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize -> authorize
            .requestMatchers("/staff/**", "/menu", "/search*", "/login*", "/register*", "/cart*", "/img/**", "/staff").permitAll()
            // .requestMatchers().authenticated()
            .anyRequest().authenticated())
            .formLogin(form -> form
            .loginPage("/loginForm"));
        return http.build();
    }
}
