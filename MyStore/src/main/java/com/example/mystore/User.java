package com.example.mystore;

// Clase que representa a un usuario en la aplicación
public class User {
    
    // Atributo que almacena el nombre de usuario
    private String username;

    // Constructor para inicializar un objeto User con un nombre de usuario proporcionado
    public User(String username) {
        this.username = username;
    }

    // Getter para obtener el nombre de usuario
    public String getUsername() {
        return username;
    }

    // Setter para establecer el nombre de usuario
    public void setUsername(String username) {
        this.username = username;
    }
}
