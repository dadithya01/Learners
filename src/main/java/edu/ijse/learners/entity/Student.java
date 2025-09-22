package edu.ijse.learners.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column
    private String studentId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private Date registrationDate;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Lesson> lessons;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Payment> payments;
}