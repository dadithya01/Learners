package edu.ijse.learners.dto.tm;

import javafx.scene.layout.Pane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LessonTM {
    private String lessonId;
    private String studentId;
    private String courseId;
    private String instructorId;
    private Date lessonDate;
    private Time startTime;
    private Time endTime;
    private String status;
    private Pane action;
}
