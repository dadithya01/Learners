package edu.ijse.learners.dao.custom;

import edu.ijse.learners.dao.CrudDAO;
import edu.ijse.learners.entity.Lesson;
import edu.ijse.learners.entity.Payment;
import edu.ijse.learners.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    boolean existsByField(String field, String fieldValue) throws Exception;
    List<Payment> getAllPayments();
    List<Payment> getAllPaymentsBySid(String sid);
    List<Lesson> getAllLessonsBySid(String sid);
}
