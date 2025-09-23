package edu.ijse.learners.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Pane controllerPane;

    @FXML
    void courseManagement(ActionEvent event) {

    }

    @FXML
    void instructorManagement(ActionEvent event) {

    }

    @FXML
    void lessonManagement(ActionEvent event) {

    }

    @FXML
    void logout(MouseEvent event) {

    }

    @FXML
    void paymentManagement(ActionEvent event) {

    }

    @FXML
    void settings(MouseEvent event) {

    }

    @FXML
    void studentManagement(ActionEvent event) throws IOException {
        controllerPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentManagements.fxml"));
        controllerPane.getChildren().add(load);
    }

    @FXML
    void userManagement(ActionEvent event) {

    }
}
