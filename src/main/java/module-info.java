module edu.ijse.learners {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;
    exports edu.ijse.learners.controllers;


    opens edu.ijse.learners.controllers to javafx.fxml;
    opens edu.ijse.learners to javafx.fxml;
    exports edu.ijse.learners;
}