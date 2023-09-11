module com.example.interfasmuseoui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfasmuseoui to javafx.fxml;
    exports com.example.interfasmuseoui;
}