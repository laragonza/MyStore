package com.example.mystore;

import com.example.mystore.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

// Clase controladora para la vista Home.fxml
public class Home {

    // Etiqueta para mostrar un mensaje de bienvenida al usuario
    @FXML
    private Label welcomeUserLabel;

    // Campo de texto para realizar búsquedas
    @FXML
    private TextField searchField;

    // Tabla para mostrar productos
    @FXML
    private TableView<Product> productTable;

    // Usuario actual en la sesión
    private User currentUser;

    // Método de inicialización, se llama después de cargar la vista
    public void initialize() {
        // Actualiza la etiqueta de bienvenida al usuario al inicializar la vista
        updateWelcomeLabel();
    }

    // Método para establecer el usuario actual
    public void setCurrentUser(User user) {
        this.currentUser = user;
        // Actualiza la etiqueta de bienvenida al usuario al cambiar el usuario
        updateWelcomeLabel();
    }

    // Método privado para actualizar la etiqueta de bienvenida
    private void updateWelcomeLabel() {
        if (currentUser != null) {
            // Si hay un usuario, muestra un mensaje de bienvenida personalizado
            welcomeUserLabel.setText("¡Bienvenido, " + currentUser.getUsername() + "!");
        } else {
            // Si no hay usuario, muestra un mensaje de bienvenida genérico
            welcomeUserLabel.setText("¡Bienvenido, Usuario!");
        }
    }

    // ... otros métodos
}
