package com.example.mystore;

import javafx.scene.control.Label;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Clase que gestiona la conexión y consultas a la base de datos
public class Bd {
    private static Connection conexion = null;
    private static Statement sentenciaSQL = null;

    public Bd() {
        super();
    }

    //----------------------------------------------------------------------------------------------------------

    // Método para conectar a la base de datos
    final Connection conectar() throws SQLException {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos MyStore en localhost, usuario "root", contraseña "root"
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
        return conexion;
    }

    // Método para desconectar de la base de datos
    public void desconectar(Connection conexion, Statement sentenciaSQL) {
        try {
            // Cerrar la sentencia SQL y la conexión
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para iniciar sesión de un usuario
    public boolean iniciarSesion(TextField email, TextField password) {
        boolean encontrado = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {
            // Conectar a la base de datos
            Connection conexion = conectar();
            Statement sentenciaSQL = conexion.createStatement();

            // Sentencia SQL para buscar un usuario con el correo y contraseña proporcionados
            sql = "SELECT userMail, userPasword FROM usuarios where userMail = '" + emailAux + "' and userPasword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentra un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                encontrado = true;
            }

            // Desconectar de la base de datos
            desconectar(conexion, sentenciaSQL);

        } catch (SQLException ex) {
            System.out.println("ERROR at login");
        }

        return encontrado;
    }

    // Método para buscar un usuario por su correo
    public boolean buscar(TextField email) {
        boolean repetido = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();

        try {
            // Conectar a la base de datos
            Connection conexion = conectar();
            Statement sentenciaSQL = conexion.createStatement();

            // Sentencia SQL para buscar un usuario con el correo proporcionado
            sql = "SELECT userMail FROM usuarios WHERE userMail = '" + emailAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentra un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                repetido = true;
            } else {
                System.out.println("User not found");
            }

            // Desconectar de la base de datos
            desconectar(conexion, sentenciaSQL);

        } catch (SQLException ex) {
            System.out.println("ERROR at login");
        }

        return repetido;
    }

    // Método para obtener la conexión a la base de datos
    public Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos MyStore en localhost, usuario "root", contraseña "root"
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conexion;
    }
}

