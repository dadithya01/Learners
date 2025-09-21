package edu.ijse.learners.tdm;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentTM {
    private String studentId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String contactNumber;
}