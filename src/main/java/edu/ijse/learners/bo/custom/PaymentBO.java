package edu.ijse.learners.bo.custom;

import edu.ijse.learners.bo.SuperBO;
import edu.ijse.learners.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentBO extends SuperBO {
    List<PaymentDTO> getAllPayments() throws Exception;

    String getLastPaymentId() throws Exception;

    boolean savePayments(PaymentDTO t) throws Exception;

    boolean updatePayments(PaymentDTO t) throws Exception;

    boolean deletePayments(String id) throws Exception;

    List<String> getAllPaymentIds() throws Exception;

    Optional<PaymentDTO> findByPaymentId(String id) throws Exception;

    String generateNewPaymentId();
}
