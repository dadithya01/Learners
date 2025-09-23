package edu.ijse.learners.tdm;

import javafx.scene.layout.Pane;
import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentTM {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private Date registrationDate;
    private List<String> courseIds;
    private Pane action;
}