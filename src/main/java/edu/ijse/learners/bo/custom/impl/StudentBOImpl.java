package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.SuperBO;
import edu.ijse.learners.bo.custom.StudentBO;
import edu.ijse.learners.bo.util.EntityToDTO;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.custom.StudentDAO;
import edu.ijse.learners.dto.StudentDTO;
import edu.ijse.learners.entity.Lesson;
import edu.ijse.learners.entity.Payment;
import edu.ijse.learners.entity.Student;
import edu.ijse.learners.exception.DuplicateException;
import edu.ijse.learners.exception.InUseException;
import edu.ijse.learners.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final EntityToDTO converter = new EntityToDTO();

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentsList = studentDAO.getAll();
        List<StudentDTO> studentsDTOList = new ArrayList<>();
        for (Student students : studentsList) {
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
        Optional<Student> students = studentDAO.findById(t.getStudentId());
        if (students.isPresent()) {
            throw new DuplicateException("Student already exists");
        }
        return studentDAO.save(converter.getStudentsEntity(t));
    }

    @Override
    public boolean updateStudents(StudentDTO t) throws Exception {
        Optional<Student> students = studentDAO.findById(t.getStudentId());
        if (students.isEmpty()) {
            throw new DuplicateException("Student Not Found");
        }
        return studentDAO.update(converter.getStudentsEntity(t));
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {
        Optional<Student> students = studentDAO.findById(id);
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
        Optional<Student> students = studentDAO.findById(id);
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
