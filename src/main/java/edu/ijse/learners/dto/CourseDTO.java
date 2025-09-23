package edu.ijse.learners.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CourseDTO {
    private String courseId;
    private String course_name;
    private String duration;
    private double fee;
    private String description;
    private String instructorId;
    @Builder.Default
    private ArrayList<LessonDTO> lessons = new ArrayList<>();
}