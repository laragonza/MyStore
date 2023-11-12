package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Clase controladora para la vista principal (MainView.fxml)
public class MainViewController implements Initializable {

    // Botones y campos de texto de la interfaz gráfica
    @FXML
    private Button btnMostrarInicioSesion, btnMostrarRegistro;

    @FXML
    private TextField txtMostrar;

    @FXML
    private MediaView mediaView;

    // Archivo y objetos relacionados con el reproductor de video
    File file = new File("C:\\Users\\Raúl\\IdeaProjects\\MyStore\\src\\main\\resources\\Vid\\VideoPrincipal.mp4");
    private Media media;
    private MediaPlayer mediaPlayer;

    // Instancia de la clase principal de la aplicación para la gestión de vistas
    HelloApplication main = new HelloApplication();

    // Dirección de las diferentes vistas que se podrán usar
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    // Método de inicialización, se llama después de cargar la vista
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configuración del reproductor de video
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();  // Reproducción automática del video
    }

    // Método para mostrar la vista de inicio de sesión al hacer clic en el botón correspondiente
    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            // Cerrar la página actual y mostrar la vista de inicio de sesión
            main.cerrarPagina(event, btnMostrarInicioSesion);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar la vista de registro al hacer clic en el botón correspondiente
    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            // Cerrar la página actual y mostrar la vista de registro
            main.cerrarPagina(event, btnMostrarRegistro);
            main.mostrarPagina(event, loaderRegistro);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
