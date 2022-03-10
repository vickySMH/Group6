module com.example.daycare {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.daycare to javafx.fxml;
    exports com.example.daycare;
}