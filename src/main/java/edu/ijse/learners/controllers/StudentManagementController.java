package edu.ijse.learners.controllers;

import edu.ijse.learners.bo.BOFactory;
import edu.ijse.learners.bo.custom.CourseBO;
import edu.ijse.learners.bo.custom.StudentBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StudentManagementController {
    @FXML
    private TableColumn<?, ?> ColAddress;

    @FXML
    private TextField DOB;

    @FXML
    private TableColumn<?, ?> Emailcol;

    @FXML
    private TextField RegDate;

    @FXML
    private TableColumn<?, ?> RegDateCol;

    @FXML
    private TextField address;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colCourses;

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
    private TextField eMail;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField studentId;

    @FXML
    private TableView<?> tblStudents;

    private final StudentBO studentsBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);
    private final CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);

    private final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final String phoneRegex = "^07\\d{8}$";

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
