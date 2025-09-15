package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.StudentBO;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.custom.StudentDAO;
import edu.ijse.learners.dto.StudentDTO;
import edu.ijse.learners.entity.Payment;

import java.util.List;
import java.util.Optional;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public List<Payment> getAllPayments() {
        return List.of();
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        return List.of();
    }

    @Override
    public String getLastId() throws Exception {
        return "";
    }

    @Override
    public boolean save(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean update(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public List<String> getAllIds() throws Exception {
        return List.of();
    }

    @Override
    public Optional<StudentDTO> findById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public String loadNextId() throws Exception {
        return "";
    }
}
