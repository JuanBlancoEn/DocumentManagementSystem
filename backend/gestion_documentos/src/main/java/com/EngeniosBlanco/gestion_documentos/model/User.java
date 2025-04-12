package com.EngeniosBlanco.gestion_documentos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.lang.*;

@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    private final String id;

    @Column(nullable= false, unique = true)
    @Setter private String username;

    @Column(nullable= false)
    @Setter private String password;

    @Column(nullable= false, unique = true)
    @Setter private String email;

    public User(String username, String password, String email) {
        this.id = idGenerator();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String idGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // Métodos para autenticación y gestión de usuarios
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("Usuario desconectado");
    }

    public void recoverPassword(String newPassword) {
        this.password = newPassword;
    }

    public static User createUser(String username, String password, String email) {
        return new User(username, password, email);
    }

    public void modifyUser(String newUsername, String newEmail) {
        this.username = newUsername;
        this.email = newEmail;
    }

    public void deleteUser() {
        System.out.println("Usuario eliminado");
    }

    public void consultUser() {
        System.out.println("ID: " + id + ", Usuario: " + username + ", Email: " + email);
    }
}
