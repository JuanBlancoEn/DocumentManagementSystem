import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;

    public User(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }

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
        return new User(UUID.randomUUID(), username, password, email);
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
