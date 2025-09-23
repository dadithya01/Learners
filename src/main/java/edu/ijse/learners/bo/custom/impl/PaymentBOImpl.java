package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.PaymentBO;
import edu.ijse.learners.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public class PaymentBOImpl implements PaymentBO {
    @Override
    public List<PaymentDTO> getAllPayments() throws Exception {
        return List.of();
    }

    @Override
    public String getLastPaymentId() throws Exception {
        return "";
    }

    @Override
    public boolean savePayments(PaymentDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean updatePayments(PaymentDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean deletePayments(String id) throws Exception {
        return false;
    }

    @Override
    public List<String> getAllPaymentIds() throws Exception {
        return List.of();
    }

    @Override
    public Optional<PaymentDTO> findByPaymentId(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public String generateNewPaymentId() {
        return "";
    }
}
