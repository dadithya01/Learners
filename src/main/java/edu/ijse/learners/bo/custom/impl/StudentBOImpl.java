package edu.ijse.learners.bo.custom.impl;

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

import java.util.List;
import java.util.Optional;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final EntityToDTO entityToDTO = new EntityToDTO();

    @Override
    public List<Payment> getAllPayments() {
        return studentDAO.getAllPayments();
    }

    @Override
    public List<Payment> getAllPaymentsBySid(String sid) {
        return studentDAO.getAllPaymentsBySid(sid);
    }

    @Override
    public List<Lesson> getAllLessonsBySid(String sid) {
        return studentDAO.getAllLessonsBySid(sid);
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        return entityToDTO.toStudentDTOList(studentDAO.getAll());
    }

    @Override
    public String getLastId() throws Exception {
        return studentDAO.getLastId();
    }

    @Override
    public boolean save(StudentDTO studentDTO) throws Exception {
        Optional<Student> studentById = studentDAO.findById(studentDTO.getStudentId());
        if (studentById.isPresent()) {
            throw new DuplicateException("Student already exists");
        }
        if (studentDAO.existsByField("contactNumber", studentDTO.getContactNumber())) {
            throw new InUseException("Contact number already exists");
        }
        if (studentDAO.existsByField("email", studentDTO.getEmail())) {
            throw new InUseException("Email already exists");
        }
        return studentDAO.save(entityToDTO.getStudentEntity(studentDTO));
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        Optional<Student> studentById = studentDAO.findById(studentDTO.getStudentId());
        if (studentById.isEmpty()) {
            throw new NotFoundException("Student doesn't exists");
        }
        Student existingStudent = existingStudent = studentById.get();
        if (!existingStudent.getContactNumber().equals(studentDTO.getContactNumber())) {
            if (studentDAO.existsByField("contactNumber", studentDTO.getContactNumber())) {
                throw new InUseException("Contact number already exists to another student");
            }
        }
        if (!existingStudent.getEmail().equals(studentDTO.getEmail())) {
            if (studentDAO.existsByField("email", studentDTO.getEmail())) {
                throw new InUseException("Email already exists to another student");
            }
        }
        return studentDAO.update(entityToDTO.getStudentEntity(studentDTO));
    }

    @Override
    public boolean delete(String id) throws Exception {
        Optional<Student> studentById = studentDAO.findById(id);
        if (studentById.isEmpty()) {
            throw new NotFoundException("Student doesn't exists");
        }
        return studentDAO.delete(id);
    }

    @Override
    public List<String> getAllIds() throws Exception {
        return studentDAO.getAllIds();
    }

    @Override
    public Optional<StudentDTO> findById(String id) throws Exception {
        return studentDAO.findById(id).map(student -> {
            try {
                return entityToDTO.getStudentDTO(student);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to convert Student to DTO, findById", e);
            }
        });
    }

    @Override
    public String loadNextId() throws Exception {
        String lastId = getLastId();
        String prefix = "STD-%03d";
        if (lastId != null) {
            String lastIdNumString = lastId.substring(4);
            int lastIdNum = Integer.parseInt(lastIdNumString);
            return String.format(prefix, lastIdNum + 1);
        }
        return String.format(prefix, 1);
    }
}
