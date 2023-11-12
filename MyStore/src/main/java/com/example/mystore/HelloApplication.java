package com.example.mystore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

// Clase principal de la aplicación que extiende la clase Application de JavaFX
public class HelloApplication extends Application {

    // Método principal para iniciar la aplicación
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            // Cargar la vista principal desde el archivo FXML (MainView.fxml)
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para manejar el evento de mostrar una página
    @FXML
    void mostrarPagina(ActionEvent event, FXMLLoader fxmlLoader) {
        try {
            // Cargar la nueva vista utilizando el FXMLLoader proporcionado
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar la página actual
    @FXML
    public void cerrarPagina(ActionEvent event, Button btnEmpezar) {
        try {
            // Obtener la instancia de Stage que contiene el botón btnEmpezar
            Stage stage = (Stage) btnEmpezar.getScene().getWindow();
            // Ocultar la ventana actual, proporcionando la opción de reabrir la vista más tarde
            stage.hide();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
    @FXML
    public void starts(Stage primaryStage) throws Exception {
        // ... otros métodos

        // Crear un FXMLLoader para cargar la vista Home.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena y establecerla en el escenario principal
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Obtener la instancia del controlador Home y establecer el usuario actual
        Home homeController = loader.getController();
        User currentUser = // lógica para obtener el usuario actual ;
        homeController.setCurrentUser(currentUser);

        // Mostrar el escenario
        primaryStage.show();
    }
    */
}
