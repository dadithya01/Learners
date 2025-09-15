package edu.ijse.learners.bo.custom;

import edu.ijse.learners.bo.CrudBO;
import edu.ijse.learners.dto.StudentDTO;
import edu.ijse.learners.entity.Payment;

import java.util.List;

public interface StudentBO extends CrudBO<StudentDTO> {
    List<Payment> getAllPayments();
}
