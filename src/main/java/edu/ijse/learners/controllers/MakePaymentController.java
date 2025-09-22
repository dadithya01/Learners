package edu.ijse.learners.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MakePaymentController {
    @FXML
    private TextField amount;

    @FXML
    private AnchorPane ancMakePayment;

    @FXML
    private CheckBox card;

    @FXML
    private CheckBox cash;

    @FXML
    private DatePicker datePicker;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void pay(ActionEvent event) {

    }
}
