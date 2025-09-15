package edu.ijse.learners.dao.custom;

import edu.ijse.learners.dao.CrudDAO;
import edu.ijse.learners.entity.Payment;
import edu.ijse.learners.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<Payment> getAllPayments();
}
