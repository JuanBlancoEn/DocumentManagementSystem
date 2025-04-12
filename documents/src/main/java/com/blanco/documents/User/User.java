package com.blanco.documents.User;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable= false, unique = true)
    @Setter private String username;

    @Column(nullable= false)
    @Setter private String password;

    @Column(nullable = false, unique = true)
    @Setter private String email;

    public User(){}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
  public String toString() {
    return String.format(
        "user[id=%s, username='%s', email='%s']",
        id, username, email);
  }

}
