package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.UserBO;
import edu.ijse.learners.bo.exception.DuplicateException;
import edu.ijse.learners.bo.exception.NotFoundException;
import edu.ijse.learners.bo.util.EntityDTOConverter;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.DAOTypes;
import edu.ijse.learners.dao.custom.UserDAO;
import edu.ijse.learners.dto.UserDTO;
import edu.ijse.learners.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {

    private  final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<User> userList = userDAO.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(converter.getUserDTO(user));
        }
        return userDTOList;
    }

    @Override
    public String getLastUserId() throws Exception {
        return userDAO.getLastId();
    }

    @Override
    public boolean saveUsers(UserDTO t) throws Exception {
        Optional<User> user = userDAO.findById(t.getUserId());
        if (user.isPresent()) {
            throw new DuplicateException("User already exists");
        }
        return userDAO.save(converter.getUserEntity(t));

    }

    @Override
    public boolean updateUsers(UserDTO t) throws Exception {
        Optional<User> user = userDAO.findById(t.getUserId());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.update(converter.getUserEntity(t));
    }

    @Override
    public boolean deleteUsers(String id) throws Exception {
        Optional<User> user = userDAO.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.delete(id);
    }

    @Override
    public List<String> getAllUserIds() throws Exception {
        return userDAO.getAllIds();
    }

    @Override
    public Optional<UserDTO> findByUserId(String id) throws Exception {
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()) {
            return Optional.of(converter.getUserDTO(user.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String generateNextUserId() {
        return userDAO.generateNewId();
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userDAO.getUserByEmail(email);

        // 2. Check if the user object is null before trying to use it
        if (user != null) {
            // If user is not null, proceed as normal
            return converter.getUserDTO(user);
        } else {
            // Handle the case where the user was not found
            // You can return null, throw an exception, or return an empty object
            System.out.println("No user found with that email: " + email);
            return null; // or throw new NotFoundException("User not found");
        }
    }
}
