package com.blanco.documents.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserDetailsService customUserDetailsService;

    public SecurityConfig(UserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/register", "/home").permitAll() // Permite el acceso libre a /login, /register, /home
                .requestMatchers("/api/**").permitAll() // Permite el acceso libre a /api/**
                .anyRequest().authenticated() // El resto requiere autenticación
            )
            .formLogin(form -> form  // Usar la configuración por defecto para formLogin
                .permitAll()  // Permite acceso libre a la página de login
                .defaultSuccessUrl("/home", true)  // Redirige a /home después del login exitoso
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")  // Redirige al login después de logout
            )
            .userDetailsService(customUserDetailsService);  // Utiliza nuestro UserDetailsService personalizado

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
