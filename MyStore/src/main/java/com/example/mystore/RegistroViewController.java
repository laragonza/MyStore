package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

// Clase controladora para la vista de registro (RegistroView.fxml)
public class RegistroViewController {

    // Campos y controles de la interfaz gráfica
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnLogin;

    // Instancias de otras clases necesarias
    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    FXMLLoader loaderLogin2 = new FXMLLoader(getClass().getResource("HomeView.fxml"));

    // Método para mostrar la vista de inicio de sesión al hacer clic en el botón correspondiente
    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            // Cerrar la página actual y mostrar la vista de inicio de sesión
            main.cerrarPagina(event, btnLogin);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Método para realizar el registro de un nuevo usuario al hacer clic en el botón correspondiente
    @FXML
    void showHome(ActionEvent event) {
        String nombreAux = txtNombre.getText();
        String apellidosAux = txtApellidos.getText();
        String emailAux = txtMail.getText();
        String passwordAux = txtPassword.getText();

        try {
            // Verificar si el correo no está repetido en la base de datos
            if (!baseDatos.buscar(txtMail)) {
                // El correo no está repetido, se puede realizar el registro

                // Aquí se ejecuta la sentencia SQL para insertar el nuevo usuario en la base de datos
                String sql = "INSERT INTO usuarios (userName, userSurname, userMail, userPasword) VALUES " +
                        "('" + nombreAux + "', '" + apellidosAux + "', '" + emailAux + "', '" + passwordAux + "')";

                // Ejecuta la sentencia SQL
                Connection conexion = baseDatos.obtenerConexion();
                Statement statement = null;

                try {
                    statement = conexion.createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                }

                // Cerrar la conexión
                baseDatos.desconectar(conexion, statement);

                // Una vez registrado, puedes redirigir al usuario a la vista principal
                main.cerrarPagina(event, btnAcceder);
                main.mostrarPagina(event, loaderLogin2);
            } else {
                // El correo ya está repetido, muestra un mensaje de error o realiza alguna acción correspondiente
                // Puedes mostrar un mensaje de error en la interfaz de usuario o tomar otras medidas necesarias
                // Por ejemplo:
                // Mostrar un mensaje de error en un Label o un diálogo de error
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
