package edu.ijse.learners.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum UserRole {
    ADMIN,
    RECEPTIONIST
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users") // Changed to 'users' to avoid SQL reserved keyword conflicts
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id", nullable = false, unique = true)
    private String id;

    @Column(name = "user_Name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String userName, String password, UserRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}