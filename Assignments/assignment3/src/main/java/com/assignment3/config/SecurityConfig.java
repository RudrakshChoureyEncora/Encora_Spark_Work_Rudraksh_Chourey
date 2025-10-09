package com.assignment3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.assignment3.security.CustomAccessDeniedHandler;
import com.assignment3.security.JwtRequestFilter;

@Configuration
public class SecurityConfig {

//    private final SecurityFilterChain filterChain;

    private final JwtRequestFilter jwtRequestFilter;
    
    private final CustomAccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter,CustomAccessDeniedHandler accessDeniedHandler) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.accessDeniedHandler=accessDeniedHandler;
//        this.filterChain = filterChain;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                	.requestMatchers("/api/login").permitAll() // Allow token generation without auth 
                    .requestMatchers("/api/admin").hasRole("ADMIN")     // Role check
                    .requestMatchers("/api/hello").authenticated()
                    .anyRequest().permitAll()
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler)) //   Register handler 
                .build();
    }
}
