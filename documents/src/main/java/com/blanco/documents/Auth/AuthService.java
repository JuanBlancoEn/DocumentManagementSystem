package com.blanco.documents.Auth;

import com.blanco.documents.User.User;
import com.blanco.documents.User.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    // Función para validar el inicio de sesión
    public boolean validateUserLogin(String username, String rawPassword) {
        // Buscar el usuario por su nombre de usuario
        Optional<User> userOpt = userRepository.findByUsername(username);

        // Si el Optional contiene un valor, extraemos el usuario y validamos la contraseña
        if (userOpt.isPresent()) {
            User user = userOpt.get();  // Obtiene el usuario
            if (passwordService.matches(rawPassword, user.getPassword())) {
                return true;  // Contraseña válida
            }
        }

        // Si no se encuentra el usuario o la contraseña no coincide
        return false;
    }
}
