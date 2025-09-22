package edu.ijse.learners.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class LessonDTO {
    private String lessonId;
    private String studentId;
    private String courseId;
    private String instructorId;
    private Date lessonDate;
    private Time startTime;
    private Time endTime;
    private String status;
}