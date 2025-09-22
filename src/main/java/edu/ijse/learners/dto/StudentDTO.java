package edu.ijse.learners.dto;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StudentDTO {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private Date registrationDate;
    private List<String> courseIds;
    @Builder.Default
    private ArrayList<StudentCourseDetailsDTO> studentCourseDetails = new ArrayList<>();
    @Builder.Default
    private ArrayList<LessonDTO> lessons =new ArrayList<>();
    @Builder.Default
    private ArrayList<PaymentDTO> payments =new ArrayList<>();
}