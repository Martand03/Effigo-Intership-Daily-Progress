package com.inEffigo.spring_csrf_cors.csrfToken;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringAuthConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.httpBasic();
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var admin = User.withUsername("Shiv")
                .password("{noop}nandi")
                .roles("ADMIN")
                .build();

        var user = User.withUsername("Ganesh")
                .password("{noop}mushak")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
