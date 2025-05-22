package com.blanco.documents.User;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blanco.documents.Auth.PasswordService;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordService passwordService;

    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public User saveUser(User user) {
        // Cifrar la contraseña antes de guardar
        user.setPassword(passwordService.encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

        // Método para verificar si la contraseña es correcta
    public boolean validatePassword(String rawPassword, String storedPassword) {
        return passwordService.matches(rawPassword, storedPassword);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> getUserByName(String username) {
        // Devolver el primer usuario encontrado (en caso de que existan múltiples, debería ser un error)
        return userRepository.findByUsername(username).stream().findFirst();
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // Nuevo método para validar el login
    public boolean authenticateUser(String username, String rawPassword) {
        Optional<User> userOptional = getUserByName(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Comparar la contraseña ingresada con la almacenada (cifrada)
            return passwordService.matches(rawPassword, user.getPassword());
        }

        return false; // Usuario no encontrado
    }

    public User updateUser(UUID id, User updatedUser) {
        User existing = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    
        existing.setUsername(updatedUser.getUsername());
        existing.setEmail(updatedUser.getEmail());
        // No cambies password aquí por seguridad
        return userRepository.save(existing);
    }

    public void updatePassword(UUID id, String newPassword) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    
        user.setPassword(passwordService.encodePassword(newPassword));
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
