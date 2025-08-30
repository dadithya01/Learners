module edu.ijse.learners {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ijse.learners to javafx.fxml;
    exports edu.ijse.learners;
}