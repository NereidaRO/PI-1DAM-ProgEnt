/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Gestion;

import PI_Tablas.*;
import java.util.Objects;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 * Esta clase dirigirá la información que viene desde Conexion (base de datos) hacia los diferentes puntos de la aplicación
 */
public class Gestion {
    private Conexion conexion;

    //Cuando se crea el gestor, se establece la conexión (que solo tiene un usuario, sa, no es paramétrica)
    public Gestion() {
        this.conexion = new Conexion();
    }

    public Conexion getConexion() {
        return conexion;
    }

    //Hacer un método público setConexion() puede derivar en problemas de seguridad, ya que se podría redirigir la aplicación a otra base de datos.

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.conexion);
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
        final Gestion other = (Gestion) obj;
        return Objects.equals(this.conexion, other.conexion);
    }

    @Override
    public String toString() {
        return "Gestion{" + "conexion=" + conexion + '}';
    }
    
    //Métodos de búsqueda + traspaso
    public Usuario buscarUsuario(int idUsuario){
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement();

            String query = "select NIF, nombre, apellidos, direccion, email, rol, fechaNacim "
            + "from Tarea where usuarioID ="+ idUsuario;

            ResultSet resultados = stmt.executeQuery(query);

            if(resultados.next()){
            System.out.println("Usuario "+idUsuario+":");
            System.out.println("NIF: " + resultados.getString("NIF"));
            System.out.println("Nombre: " + resultados.getString("nombre"));
            System.out.println("Apellidos: " + resultados.getString("apellidos"));
            System.out.println("Dirección: " + resultados.getString("direccion"));
            System.out.println("Correo: " + resultados.getString("email"));
            System.out.println("Rol: " + resultados.getString("rol"));
            System.out.println("Fecha de nacimiento: " + resultados.getString("fechaNacim"));

            Usuario usuario = new Usuario(idUsuario, resultados.getString("NIF"), resultados.getString("nombre"),
            resultados.getString("apellidos"), resultados.getString("direccion"), resultados.getString("email")
            , resultados.getString("rol"), resultados.getDate("fechaNacim")); 

            return usuario; 

            }else{ 

            System.out.println("No hay usuario con ese ID"); 

            return null; 

            } 

            }catch (SQLException e) { 

            System.out.println("Error: No se pudo conectar a la base de datos."); 

            e.printStackTrace(); 
            return null;
            }

    
    }
    public Averia buscarAveria(int idAveria){

        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement();

            String query = "select FechaReporte, FechaReparacion, Duracion, Coste, AveriaDescrip, Comentario, UsuarioID"
            + "from Averia where AveriaID ="+ idAveria;

            ResultSet resultados = stmt.executeQuery(query);

            if(resultados.next()){
            System.out.println("Averia "+idAveria+":");
            System.out.println("Fecha de Reporte: " + resultados.getString("FechaReporte"));
            System.out.println("Fecha de Reparacion: " + resultados.getString("FechaReparacion"));
            System.out.println("Duracion: " + resultados.getString("Duracion"));
            System.out.println("Coste: " + resultados.getString("Coste"));
            System.out.println("Descripcion de la Averia: " + resultados.getString("AveriaDescrip"));
            System.out.println("Comentario: " + resultados.getString("Comentario"));
            System.out.println("Reportador: " + resultados.getString("UsuarioID"));
            
            Averia averia = new Averia(idAveria, resultados.getDate("FechaReporte"), resultados.getDate("FechaReparacion"), resultados.getFloat("Duracion"), resultados.getInt("Coste"),
            resultados.getString("AveriaDescrip"), resultados.getString("Comentario"));
            
            return averia;
            
            }else{ 

            System.out.println("No hay avería con ese ID"); 
            return null;
            } 

        }catch (SQLException e) { 

        System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
        return null;
        }
}
    public Maquina buscarMaquina( int idMaquina){
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String query = "select MaquinaDescrip, Tipo, Ubicacion, Horas, Estado, FechaManten, UsuarioID "
            + "from Maquina where MaquinaID ="+ idMaquina;
            ResultSet resultados = stmt.executeQuery(query);
            if(resultados.next()){
            System.out.println("Maquina "+idMaquina+":");
            System.out.println("Nombre: " + resultados.getString("MaquinaDescrip"));
            System.out.println("Tipo: " + resultados.getString("Tipo"));
            System.out.println("Ubicacion: " + resultados.getString("Ubicacion"));
            System.out.println("Horas: " + resultados.getString("Horas"));
            System.out.println("Estado: " + resultados.getString("Estado"));
            System.out.println("FechaManten: " + resultados.getString("FechaManten"));
            System.out.println("Responsable: " + resultados.getString("UsuarioID"));
            boolean status;
            if (resultados.getString("Estado")=="Activa"){
                status = true;
            }else{
                status = false;
            }
            Maquina maq = new Maquina(idMaquina, resultados.getString("MaquinaDescrip"), resultados.getString("Tipo"), resultados.getString("Ubicacion"), 
                    resultados.getInt("Horas"), status,
			resultados.getDate("FechaManten"), resultados.getInt("UsuarioID"));
            return maq;
            }else{
                System.out.println("No hay máquinas con ese ID");
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    public Tarea buscarTarea(int idTarea){
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement();

            String query = "select TareaNombre, TareaDescrip "
            + "from Tarea where TareaID ="+ idTarea;

            ResultSet resultados = stmt.executeQuery(query);

            if(resultados.next()){
            System.out.println("Tarea "+idTarea+":");

            System.out.println("Nombre: " + resultados.getString("TareaNombre"));
            System.out.println("Descripción: " + resultados.getString("TareaDescrip"));

            Tarea tarea = new Tarea(idTarea, resultados.getString("TareaNombre"), resultados.getString("TareaDescrip")); 

            return tarea; 

            }else{ 

            System.out.println("No hay tarea con ese ID"); 

            return null; 

            } 

        }catch (SQLException e) { 

        System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
        return null;
    }

    
    }
    
    //Métodos de listado
    public void listaUsuarios(){
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement(); 

            String query = "select usuarioID, NIF, nombre, apellidos, direccion, email, rol, fechaNacim from Usuario";

            ResultSet resultados = stmt.executeQuery(query);

            System.out.println("Listado de Usuarios:");

            while(resultados.next()) {
            System.out.println("UsuarioID: " + resultados.getString("usuarioID") + " - " 
            + "NIF: "+ resultados.getString("NIF")
            + "Nombre: " + resultados.getString("nombre") 
            + "Apellidos: "+ resultados.getString("apellidos")
            + "Direccion: "+ resultados.getString("direccion")
            + "Correo: "+ resultados.getString("email")
            + "Rol: "+ resultados.getString("rol")
            + "Fecha de nacimiento: "+ resultados.getString("fechaNacim"));
            }
        }catch (SQLException e) { 

        System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
        }
    }
    public void listaAverias(){
        try {

        Connection c = conexion.getConection(); 

        java.sql.Statement stmt = c.createStatement(); 
        String query = "select AveriaID, FechaReporte, FechaReparacion, Duracion, Coste, AveriaDescrip, Comentario, UsuarioID from Averia";

        ResultSet resultados = stmt.executeQuery(query); 

        System.out.println("Listado de Averias:");

        while(resultados.next()) {
        System.out.println("AveriaID: " + resultados.getString("AveriaID") + " - " 
        + "Fecha de Reporte: " + resultados.getString("FechaReporte")
        + "Fecha de Reaparación: "+ resultados.getString("FechaReparacion")
        + "Duración: "+ resultados.getString("Duracion")
        + "Coste: "+ resultados.getString("Coste")
        + "Descripcion de averia: "+ resultados.getString("AveriaDescrip")
        + "Comentario: "+ resultados.getString("Comentario")
        + "Reportante: "+ resultados.getString("UsuarioID"));
        }
        }catch (SQLException e) { 

        System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
    }

    }
    public void listaMaquinas(){
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement(); 

            String query = "select MaquinaID, MaquinaDescrip, Tipo, Ubicacion, Horas, Estado, FechaManten, UsuarioID from Maquina";

            ResultSet resultados = stmt.executeQuery(query);

            System.out.println("Listado de Maquina:");

            while(resultados.next()) {
            System.out.println("MaquinaID: " + resultados.getString("MaquinaID") + " - " 
            + "Nombre: " + resultados.getString("MaquinaDescrip") 
            + "Tipo: "+ resultados.getString("Tipo")
            + "Ubicacion: "+ resultados.getString("Ubicacion")
            + "Horas de uso: "+ resultados.getString("Horas")
            + "Estado: "+ resultados.getString("Estado")
            + "Fecha de mantenimiento: "+ resultados.getString("FechaManten")
            + "Responsable: "+ resultados.getString("UsuarioID"));
            }
        }catch (SQLException e) { 

        System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
        }
    }
    public void listaTareas(){
    
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement(); 

            String query = "select TareaID, TareaNombre, TareaDescrip from Tarea";

            ResultSet resultados = stmt.executeQuery(query);

            System.out.println("Listado de Tareas:");

            while(resultados.next()) {
            System.out.println("TareaID: " + resultados.getString("TareaID") + " - " 
            + "Nombre de la tarea: " + resultados.getString("TareaNombre")
            + "Descripcion de la tarea: "+ resultados.getString("TareaDescrip"));
            }
            }catch (SQLException e) { 

            System.out.println("Error: No se pudo conectar a la base de datos."); 

            e.printStackTrace(); 
        }

    }
    
    //Métodos de creación
    public void insertarUsuario(String NIF, String nombre, String apellidos, String direccion, String email, String rol, Date fechaNacim){
        /*los ID son autoincrementales, no se ponen en la inserción*/
        try{
            int ID;
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String fechaStr = fechaNacim.toString();
            System.out.println(fechaStr);
            String query = "insert into Usuario (NIF, nombre, apellidos, direccion, email, rol, fechaNacim) values (" +
                "'" + NIF + "', " +
                "'" + nombre + "', " +
                "'" + apellidos + "', " +
                "'" + direccion + "', " +
                "'" + email + "', " +
                "'" + rol + "', " +
                "'" + fechaStr + "'" +
            ")";
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Inserción hecha con éxito. Filas afectadas: " + filasAfectadas);

            //Ver el resultado
            query = "select * from Usuario where NIF = '" + NIF +"'";
            ResultSet resultados = stmt.executeQuery(query);   
            if(resultados.next()){
                ID = resultados.getInt("usuarioID");
                System.out.println("El usuario, en la base de datos, es: ");
                System.out.println("ID: " + ID);
                System.out.println("NIF: " + resultados.getString("NIF"));
                System.out.println("Nombre: " + resultados.getString("nombre"));
                System.out.println("Apellidos: " + resultados.getString("apellidos"));
                System.out.println("Direccion: " + resultados.getString("direccion"));
                System.out.println("Email: " + resultados.getString("email"));
                System.out.println("Rol: " + resultados.getString("rol"));
                System.out.println("Fecha de Nacimiento: " + resultados.getDate("fechaNacim"));

                Usuario nUs = new Usuario(ID, NIF, nombre, apellidos, direccion, email, rol, fechaNacim);
            }
        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        
    }
    public void insertarAveria(){}
    public void insertarMaquina(){}
    public void insertarTarea(){}
    
    //Métodos para modificar
    public void modificarUsuario(int ID, String NIF, String nombre, String apellidos, String direccion, String email, String rol, Date fechaNacim){
        //buscar por ID
        //cambiar por datos nuevos
        try{
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String fechaStr = fechaNacim.toString();
            String query = "UPDATE Usuario SET NIF = '" + NIF + 
               "', nombre = '" + nombre + 
               "', apellidos = '" + apellidos + 
               "', direccion = '" + direccion + 
               "', email = '" + email + 
               "', rol = '" + rol + 
               "', fechaNacim = '" + fechaStr + 
               "' WHERE usuarioID = " + ID;
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Modificación hecha con éxito. Filas afectadas: " + filasAfectadas);
            
            //Ver el resultado
            query = "select * from Usuario where usuarioID = '" + ID +"'";
            ResultSet resultados = stmt.executeQuery(query); 
            if(resultados.next()){
                System.out.println("El usuario, en la base de datos, es: ");
                System.out.println("ID: " + resultados.getString("usuarioID"));
                System.out.println("NIF: " + resultados.getString("NIF"));
                System.out.println("Nombre: " + resultados.getString("nombre"));
                System.out.println("Apellidos: " + resultados.getString("apellidos"));
                System.out.println("Direccion: " + resultados.getString("direccion"));
                System.out.println("Email: " + resultados.getString("email"));
                System.out.println("Rol: " + resultados.getString("rol"));
                System.out.println("Fecha de Nacimiento: " + resultados.getDate("fechaNacim"));
            }
        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }
    public void modificarAveria(){}
    public void modificarMaquina(){}
    public void modificarTarea(){}
    
    //Métodos para eliminar
    public void eliminarUsuario(){ /*no te olvides el where ID es el que toca*/}
    public void eliminarAveria(){}
    public void eliminarMaquina(){}
    public void eliminarTarea(){}
}
