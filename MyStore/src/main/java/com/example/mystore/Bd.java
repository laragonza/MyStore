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
public class Bd {
    private static Connection conexion = null;
    private static Statement sentenciaSQL = null;

    public Bd() {
        super();
    }

    //----------------------------------------------------------------------------------------------------------

    // Conectar a la base de datos

    final Connection conectar() throws SQLException {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
        return conexion;
    }

    public void desconectar(Connection conexion, Statement sentenciaSQL) {
        try {
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public boolean iniciarSesion(TextField email, TextField password) {
        boolean encontrado = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {
            Connection conexion = conectar();
            Statement sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userMail, userPasword FROM usuarios where userMail = '" + emailAux + "' and userPasword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                encontrado = true;
            }

            desconectar(conexion, sentenciaSQL);

        } catch (SQLException ex) {
            System.out.println("ERROR at login");
        }

        return encontrado;
    }

    public boolean buscar(TextField email) {
        boolean repetido = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();

        try {
            Connection conexion = conectar();
            Statement sentenciaSQL = conexion.createStatement();

            // Sentencia para buscar usuarios en la tabla
            sql = "SELECT userMail FROM usuarios WHERE userMail = '" + emailAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                repetido = true;
            } else {
                System.out.println("User not found");
            }

            desconectar(conexion, sentenciaSQL);

        } catch (SQLException ex) {
            System.out.println("ERROR at login");
        }

        return repetido;
    }
    public Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conexion;
    }


}
