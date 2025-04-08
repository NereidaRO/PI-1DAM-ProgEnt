/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Conexion {
    // Datos de la conexión
    private String url;
    private String usuario;
    private String contrasenya;

    //La conexión solo está habilitada para este usuario, pero hacen falta los parámetros para crear el statement.
    public Conexion() {
        this.url="jdbc:sqlserver://127.0.0.1:1433;databaseName=PI_BADA;;encrypt=false;trustServerCertificate=true;";
        this.usuario="sa";
        this.contrasenya="k4t4kr0k3r";
        
    }
    

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    //La contraseña no debería poder modificarse ni consultarse: no getter ni setter

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conexion other = (Conexion) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Conexion{" + "url=" + url + ", usuario=" + usuario + '}';
    }
    
    public Connection getConection(){
        try{
            // Cargar el driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Conectar a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenya);
            System.out.println("Conexion exitosa a la base de datos.");
            java.sql.Statement stmt = conexion.createStatement();
            return conexion;

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
}
