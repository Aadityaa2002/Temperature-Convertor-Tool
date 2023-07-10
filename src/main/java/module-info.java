module com.example.javaapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaapp to javafx.fxml;
    exports com.example.javaapp;
}