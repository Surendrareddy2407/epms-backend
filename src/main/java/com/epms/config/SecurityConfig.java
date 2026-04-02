package com.epms.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.epms.security.JwtFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth

	            // login free
	            .requestMatchers("/api/auth/**").permitAll()

	            // ADMIN
	            .requestMatchers("/api/employees/**").hasAuthority("ADMIN")
	            .requestMatchers("/api/projects/**").hasAuthority("ADMIN")
	            .requestMatchers("/api/tasks").hasAuthority("ADMIN")

	            // EMPLOYEE
	            .requestMatchers("/api/tasks/*/status").hasAuthority("EMPLOYEE")

	            .anyRequest().authenticated()
	        )
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}