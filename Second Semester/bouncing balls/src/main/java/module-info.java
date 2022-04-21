module com.example.bouncingballs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bouncingballs to javafx.fxml;
    exports com.example.bouncingballs;
}