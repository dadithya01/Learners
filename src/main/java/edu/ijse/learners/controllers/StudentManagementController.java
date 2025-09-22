package edu.ijse.learners.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StudentManagementController {
    @FXML
    private TextField address;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colFname;

    @FXML
    private TableColumn<?, ?> colLname;

    @FXML
    private TableColumn<?, ?> colSid;

    @FXML
    private TextField contactNo;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField eMail;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField studentId;

    @FXML
    private TableView<?> tblStudents;

    @FXML
    void Add(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void makeAPayment(ActionEvent event) {

    }

    @FXML
    void onClick(MouseEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
