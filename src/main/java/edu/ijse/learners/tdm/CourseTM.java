package edu.ijse.learners.tdm;

import javafx.scene.layout.Pane;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseTM {
    private String courseId;
    private String course_name;
    private String duration;
    private double fee;
    private String description;
    private String instructorId;
    private Pane action;
}