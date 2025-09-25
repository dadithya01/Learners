package edu.ijse.learners.util;

import edu.ijse.learners.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

public class Authutil {
    @Getter
    @Setter
    private static UserDTO currentUser;

    public static String getRole() {
        return currentUser != null ? currentUser.getRole() : null;
    }

    public static void clear() {
        currentUser = null;
    }
}
