package edu.ijse.learners.dto;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class InstructorDTO {
    private String instructorId;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String specialization;
    private String availability;
    @Builder.Default
    private ArrayList<LessonDTO> lessons = new ArrayList<>();
    @Builder.Default
    private ArrayList<CourseDTO> courses = new ArrayList<>();
}