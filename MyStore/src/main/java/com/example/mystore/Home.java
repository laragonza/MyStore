package com.example.mystore;

import com.example.mystore.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Home {

    @FXML
    private Label welcomeUserLabel;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Product> productTable;

    private User currentUser;

    public void initialize() {
        updateWelcomeLabel();
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        updateWelcomeLabel();
    }

    private void updateWelcomeLabel() {
        if (currentUser != null) {
            welcomeUserLabel.setText("¡Bienvenido, " + currentUser.getUsername() + "!");
        } else {
            welcomeUserLabel.setText("¡Bienvenido, Usuario!");
        }
    }

    // ... otros métodos
}
