package edu.ijse.learners.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private AnchorPane ancMain;

    @FXML
    void login(ActionEvent event) throws IOException {
        ancMain.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/AdminDashboard.fxml"));
        ancMain.getChildren().add(load);
    }
}
