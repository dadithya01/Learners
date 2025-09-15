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
    @Column(name = "stud_id", unique = true, nullable = false)
    private String studentId;

    @Column(name = "stud_fname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "stud_lname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "stud_dob", nullable = false)
    private Date dob;

    @Column(name = "stud_email", nullable = false, unique = true)
    private String email;

    @Column(name = "stud_contact", nullable = false, unique = true, length = 15)
    private String contactNumber;

    @Column(name = "stud_address", nullable = false)
    private String address;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Payment> payments;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Lesson> lessons;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<StudentCourseDetails> studentCourseDetails;
}