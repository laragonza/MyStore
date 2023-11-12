package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginViewController {

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

    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("HomeView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            // creamos objeto del Main para poder llamar al metodo start2 */
            main.cerrarPagina(event, btnRegistro);
            main.mostrarPagina(event, loaderRegistro);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showHome(ActionEvent event) {

        boolean encontrados = false;

        try {
            encontrados = baseDatos.iniciarSesion( txtUsername, txtPassword);

            //Una vez a encontrado el usuario accedo a la siguiente vista
            if(encontrados == true){
                main.cerrarPagina(event, btnAcceder);
                main.mostrarPagina(event, loaderLogin);
            }





        } catch(Exception e) {
            e.printStackTrace();
        }

    }


}



