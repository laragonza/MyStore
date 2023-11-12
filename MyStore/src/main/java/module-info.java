module com.example.mystore {

    // Requiere las bibliotecas necesarias para JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.dlsc.formsfx;
    requires javafx.media;

    // Abre el paquete com.example.mystore para que JavaFX pueda acceder a él
    opens com.example.mystore to javafx.fxml;

    // Exporta el paquete com.example.mystore, lo que permite que otras partes del código puedan utilizarlo
    exports com.example.mystore;
}
