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

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void mostrarPagina(ActionEvent event, FXMLLoader fxmlLoader) {
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void cerrarPagina(ActionEvent event, Button btnEmpezar) {

        try {
            // selecciona la vista a la que pertenece btn1
            Stage stage = (Stage) btnEmpezar.getScene().getWindow();
            // haciendo .hide cierra la ventana con la opción de reabrir la vista
            stage.hide();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /*
    @FXML
    public void starts(Stage primaryStage) throws Exception {
        // ... otros métodos

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Obtén la instancia del controlador Home y establece el usuario actual
        Home homeController = loader.getController();
        User currentUser = // lógica para obtener el usuario actual ;
        homeController.setCurrentUser(currentUser);

        primaryStage.show();
    }
    */
}
