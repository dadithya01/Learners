module edu.ijse.learners {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.naming;
    requires jbcrypt;


    opens edu.ijse.learners.configuration to jakarta.persistence;
    opens edu.ijse.learners.entity to org.hibernate.orm.core;

    opens edu.ijse.learners.controllers to javafx.fxml;
    opens edu.ijse.learners.tdm to javafx.base;
    opens edu.ijse.learners to javafx.fxml;
    exports edu.ijse.learners;
}