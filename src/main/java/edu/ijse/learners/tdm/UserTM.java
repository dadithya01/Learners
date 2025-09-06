package edu.ijse.learners.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTM {
    private Long id;
    private String userName;
    private String password;
    private String role;
}