# MyStore
# Aplicación MyStore

MyStore es una aplicación JavaFX diseñada para gestionar usuarios y productos. La aplicación utiliza una base de datos MySQL para almacenar la información de usuarios y productos.

## Requisitos previos

Asegúrate de tener lo siguiente instalado antes de ejecutar la aplicación:

- Java JDK 8 o superior
- MySQL

## Configuración de la base de datos

La aplicación se conecta a una base de datos MySQL llamada "MyStore". Asegúrate de tener una instancia de MySQL ejecutándose localmente y modifica las credenciales de la base de datos en la clase `Bd.java`.

```java
// Bd.java
conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
```

## Estructura del proyecto

El proyecto está estructurado de la siguiente manera:

  - Bd.java: Gestiona la conexión y operaciones con la base de datos.
  - HelloApplication.java: Punto de entrada de la aplicación JavaFX.
  - Home.java: Controlador de la vista principal.
  - LoginViewController.java: Controlador de la vista de inicio de sesión.
  - MainViewController.java: Controlador de la vista principal.
  - Product.java: Clase que representa un producto.
  - RegistroViewController.java: Controlador de la vista de registro.
  - User.java: Clase que representa a un usuario.

## Características principales

- Inicio de sesión: Los usuarios pueden iniciar sesión con su dirección de correo electrónico y contraseña.
- Registro: Los nuevos usuarios pueden registrarse proporcionando su nombre, apellidos, dirección de correo electrónico y contraseña.
- Vista principal: Después de iniciar sesión, los usuarios son dirigidos a una vista principal donde pueden ver productos.

## Ejecución de la aplicación

Para ejecutar la aplicación, ejecuta la clase `HelloApplication.java`.

```bash
java com.example.mystore.HelloApplication
```

![image](https://github.com/laragonza/MyStore/assets/16885317/abf9f710-6b59-4c1b-8f86-a886fc25ce20)


