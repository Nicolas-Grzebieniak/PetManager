module com.example.petmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.petmanager to javafx.fxml;
    exports com.example.petmanager;
}