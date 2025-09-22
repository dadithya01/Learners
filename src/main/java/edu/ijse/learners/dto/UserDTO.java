package edu.ijse.learners.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String status;
}