package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.StudentBO;
import edu.ijse.learners.bo.exception.DuplicateException;
import edu.ijse.learners.bo.util.EntityDTOConverter;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.DAOTypes;
import edu.ijse.learners.dao.custom.StudentDAO;
import edu.ijse.learners.dto.StudentDTO;
import edu.ijse.learners.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENTS);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Students> studentsList = studentDAO.getAll();
        List<StudentDTO> studentsDTOList = new ArrayList<>();
        for (Students students : studentsList) {
            studentsDTOList.add(converter.getStudentsDTO(students));
        }
        return studentsDTOList;
    }

    @Override
    public String getLastStudentId() throws Exception {
        return studentDAO.getLastId();
    }

    @Override
    public boolean saveStudents(StudentDTO t) throws Exception {
        Optional<Students> students = studentDAO.findById(t.getStudentId());
        if (students.isPresent()) {
            throw new DuplicateException("Student already exists");
        }
        return studentDAO.save(converter.getStudentsEntity(t));

    }

    @Override
    public boolean updateStudents(StudentDTO t) throws Exception {
        Optional<Students> students = studentDAO.findById(t.getStudentId());
        if (students.isEmpty()) {
            throw new DuplicateException("Student Not Found");
        }
        return studentDAO.update(converter.getStudentsEntity(t));
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {
        Optional<Students> students = studentDAO.findById(id);
        if (students.isEmpty()) {
            throw new DuplicateException("Student not found");
        }
        return studentDAO.delete(id);
    }

    @Override
    public List<String> getAllStudentIds() throws Exception {
        return studentDAO.getAllIds();
    }

    @Override
    public Optional<StudentDTO> findByStudentId(String id) throws Exception {
        Optional<Students> students = studentDAO.findById(id);
        if (students.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(converter.getStudentsDTO(students.get()));
    }

    @Override
    public String generateNewStudentId() {
        return studentDAO.generateNewId();
    }
}
