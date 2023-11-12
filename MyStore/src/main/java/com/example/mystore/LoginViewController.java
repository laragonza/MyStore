package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

// Clase controladora para la vista de inicio de sesión (LoginView.fxml)
public class LoginViewController {

    // Campos y controles de la interfaz gráfica
    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnAcceder;

    @FXML
    private ImageView imgInicio;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnRegistro;

    // Instancias de otras clases necesarias
    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("HomeView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    // Método para mostrar la vista de registro al hacer clic en el botón correspondiente
    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            // Cerrar la página actual y mostrar la vista de registro
            main.cerrarPagina(event, btnRegistro);
            main.mostrarPagina(event, loaderRegistro);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar la vista Home después de intentar iniciar sesión
    @FXML
    void showHome(ActionEvent event) {
        boolean encontrados = false;

        try {
            // Intentar iniciar sesión y obtener el resultado
            encontrados = baseDatos.iniciarSesion(txtUsername, txtPassword);

            // Si se encuentra el usuario, cerrar la página actual y mostrar la vista Home
            if(encontrados) {
                main.cerrarPagina(event, btnAcceder);
                main.mostrarPagina(event, loaderLogin);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
