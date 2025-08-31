package edu.ijse.learners.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Mainpagecontroller {

    @FXML
    private AnchorPane ancMain;

    @FXML
    void btnNext(ActionEvent event) throws IOException {
        ancMain.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        ancMain.getChildren().add(load);
    }
}
