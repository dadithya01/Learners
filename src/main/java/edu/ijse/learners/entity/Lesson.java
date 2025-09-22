package edu.ijse.learners.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column
    private String lessonId;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructorId", referencedColumnName = "instructorId")
    private Instructor instructor;

    @Column
    private Date lessonDate;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

    @Column
    private String status;
}