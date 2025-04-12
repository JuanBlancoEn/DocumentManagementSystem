package com.blanco.documents.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Método para cifrar la contraseña
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Método para verificar que la contraseña es correcta
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
