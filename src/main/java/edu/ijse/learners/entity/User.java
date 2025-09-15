package edu.ijse.learners.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String age;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_contact", nullable = false, length = 15)
    private String contactNumber;

    @Column(name = "user_role", nullable = false)
    private String role;
}