module com.example.mystore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.dlsc.formsfx;
    requires javafx.media;



    opens com.example.mystore to javafx.fxml;
    exports com.example.mystore;
}