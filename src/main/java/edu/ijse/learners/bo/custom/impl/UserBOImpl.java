package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.UserBO;
import edu.ijse.learners.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {
    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        return List.of();
    }

    @Override
    public String getLastUserId() throws Exception {
        return "";
    }

    @Override
    public boolean saveUsers(UserDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean updateUsers(UserDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUsers(String id) throws Exception {
        return false;
    }

    @Override
    public List<String> getAllUserIds() throws Exception {
        return List.of();
    }

    @Override
    public Optional<UserDTO> findByUserId(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public String generateNextUserId() {
        return "";
    }
}
