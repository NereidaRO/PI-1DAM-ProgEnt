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

    /**
     *
     * @return obj
     */
    public Conexion getConexion() {
        return conexion;
    }

    //Hacer un método público setConexion() puede derivar en problemas de seguridad, ya que se podría redirigir la aplicación a otra base de datos.

    /**
     *
     * @return int
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.conexion);
        return hash;
    }

    /**
     *
     * @param obj
     * @return boolean
     */
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

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Gestion{" + "conexion=" + conexion + '}';
    }
    
    //Métodos de búsqueda + traspaso

    /**
     *
     * @param idUsuario
     * @return
     */
    public Usuario buscarUsuario(int idUsuario){
        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement();

            String query = "select NIF, nombre, apellidos, direccion, email, rol, fechaNacim "
            + "from Usuario where usuarioID ="+ idUsuario;

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

    /**
     *
     * @param idAveria
     * @return obj
     */
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
            System.out.println("Reportador: " + resultados.getInt("UsuarioID"));
            
            Averia averia = new Averia(idAveria, resultados.getDate("FechaReporte"), resultados.getDate("FechaReparacion"), resultados.getInt("Duracion"), resultados.getInt("Coste"),
            resultados.getString("AveriaDescrip"), resultados.getString("Comentario"), resultados.getInt("UsuarioID"));
            
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

    /**
     *
     * @param idMaquina
     * @return obj
     */
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

    /**
     *
     * @param idTarea
     * @return obj
     */
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

    /**
     *
     */
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

    /**
     *
     */
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

    /**
     *
     */
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

    /**
     *
     */
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

    /**
     *
     * @param NIF
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param email
     * @param rol
     * @param fechaNacim
     */
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

    /**
     *
     * @param fechaReporte
     * @param fechaReparacion
     * @param duracion
     * @param coste
     * @param averiaDescrip
     * @param comentario
     * @param usuarioID
     */
    public void insertarAveria( Date fechaReporte, Date fechaReparacion, int duracion, int coste, String averiaDescrip, String comentario, int usuarioID){

        try {
         int ID;
         Connection c = conexion.getConection();
         java.sql.Statement stmt = c.createStatement();

         // Definir las variables para la avería
         String fechaReporteStr = fechaReporte.toString();
         String fechaReparacionStr = fechaReparacion.toString();

         System.out.println(fechaReporteStr + " - " + fechaReparacionStr);

         // Query para insertar la avería
         String query = "insert into Averia (FechaReporte, FechaReparacion, Duracion, Coste, AveriaDescrip, Comentario, UsuarioID) values (" +
         "'" + fechaReporteStr + "', " +
         "'" + fechaReparacionStr + "', " +
         "'" + duracion + "', " +
         "'" + coste + "', " +
         "'" + averiaDescrip + "', " +
         "'" + comentario + "'" + ","
         + usuarioID  +
         ")";

         int filasAfectadas = stmt.executeUpdate(query);
         System.out.println("Inserción hecha con éxito. Filas afectadas: " + filasAfectadas);

         // Ver el resultado
         query = "select * from Averia where FechaReporte = '" + fechaReporteStr + "'";
         ResultSet resultados = stmt.executeQuery(query); 
         if (resultados.next()) {
         ID = resultados.getInt("AveriaID");
         System.out.println("La avería, en la base de datos, es: ");
         System.out.println("ID: " + ID);
         System.out.println("Fecha de Reporte: " + resultados.getDate("FechaReporte"));
         System.out.println("Fecha de Reparación: " + resultados.getDate("FechaReparacion"));
         System.out.println("Duración: " + resultados.getInt("Duracion"));
         System.out.println("Coste: " + resultados.getDouble("Coste"));
         System.out.println("Descripción de la Avería: " + resultados.getString("AveriaDescrip"));
         System.out.println("Comentario: " + resultados.getString("Comentario"));

         // Crear un objeto de la clase Averia con los datos obtenidos
         Averia nuevaAveria = new Averia(ID, fechaReporte, fechaReparacion, duracion, coste, averiaDescrip, comentario, usuarioID);
         }

        } catch (SQLException e) {
         System.out.println("Error: No se pudo conectar a la base de datos.");
         e.printStackTrace();
        }
    }

    /**
     *
     * @param maquinaDescrip
     * @param tipo
     * @param ubicacion
     * @param horas
     * @param estado
     * @param fechaManten
     * @param usuarioID
     */
    public void insertarMaquina(String maquinaDescrip, String tipo, String ubicacion, int horas, boolean estado, Date fechaManten, int usuarioID){

        try {
         int ID;
         Connection c = conexion.getConection();
         java.sql.Statement stmt = c.createStatement();

         // Definir las variables para la máquina
         String fechaMantenStr = fechaManten.toString();

         System.out.println(fechaMantenStr);

         // Query para insertar la máquina
         String query = "insert into Maquina (MaquinaDescrip, Tipo, Ubicacion, Horas, Estado, FechaManten, UsuarioID) values (" +
         "'" + maquinaDescrip + "', " +
         "'" + tipo + "', " +
         "'" + ubicacion + "', " +
         "'" + horas + "', " +
         "'" + estado + "', " +
         "'" + fechaMantenStr + "', " +
         "'" + usuarioID + "'" +
         ")";

         int filasAfectadas = stmt.executeUpdate(query);
         System.out.println("Inserción hecha con éxito. Filas afectadas: " + filasAfectadas);

         // Ver el resultado
         query = "select * from Maquina where MaquinaDescrip = '" + maquinaDescrip + "' and UsuarioID = " + usuarioID;
         ResultSet resultados = stmt.executeQuery(query); 
         if (resultados.next()) {
         ID = resultados.getInt("MaquinaID");
         System.out.println("La máquina, en la base de datos, es: ");
         System.out.println("ID: " + ID);
         System.out.println("Descripción de la Maquina: " + resultados.getString("MaquinaDescrip"));
         System.out.println("Tipo: " + resultados.getString("Tipo"));
         System.out.println("Ubicación: " + resultados.getString("Ubicacion"));
         System.out.println("Horas: " + resultados.getInt("Horas"));
         System.out.println("Estado: " + resultados.getString("Estado"));
         System.out.println("Fecha de Mantenimiento: " + resultados.getDate("FechaManten"));
         System.out.println("UsuarioID: " + resultados.getInt("UsuarioID"));

         // Crear un objeto de la clase Maquina con los datos obtenidos
         Maquina nuevaMaquina = new Maquina(ID, maquinaDescrip, tipo, ubicacion, horas, estado, fechaManten, usuarioID);
         }

        } catch (SQLException e) {
         System.out.println("Error: No se pudo conectar a la base de datos.");
         e.printStackTrace();
        }
    }

    /**
     *
     * @param tareaNombre
     * @param tareaDescrip
     */
    public void insertarTarea(String tareaNombre, String tareaDescrip){

        try {
         int ID;
         Connection c = conexion.getConection();
         java.sql.Statement stmt = c.createStatement();

         // Query para insertar la tarea
         String query = "insert into Tarea (TareaNombre, TareaDescrip) values (" +
         "'" + tareaNombre + "', " +
         "'" + tareaDescrip + "'" +
         ")";

         int filasAfectadas = stmt.executeUpdate(query);
         System.out.println("Inserción hecha con éxito. Filas afectadas: " + filasAfectadas);

         // Ver el resultado
         query = "select * from Tarea where TareaNombre = '" + tareaNombre + "'";
         ResultSet resultados = stmt.executeQuery(query); 
         if (resultados.next()) {
         ID = resultados.getInt("TareaID");
         System.out.println("La tarea, en la base de datos, es: ");
         System.out.println("ID: " + ID);
         System.out.println("Nombre de la Tarea: " + resultados.getString("TareaNombre"));
         System.out.println("Descripción de la Tarea: " + resultados.getString("TareaDescrip"));

         // Crear un objeto de la clase Tarea con los datos obtenidos
         Tarea nuevaTarea = new Tarea(ID, tareaNombre, tareaDescrip);
         }

        } catch (SQLException e) {
         System.out.println("Error: No se pudo conectar a la base de datos.");
         e.printStackTrace();
        }
    }
    
    //Métodos para modificar

    /**
     *
     * @param ID
     * @param NIF
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param email
     * @param rol
     * @param fechaNacim
     */
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

    /**
     *
     * @param ID
     * @param fechaReporte
     * @param fechaReparacion
     * @param duracion
     * @param coste
     * @param averiaDescrip
     * @param comentario
     * @param usuarioID
     */
    public void modificarAveria(int ID, Date fechaReporte, Date fechaReparacion, int duracion, int coste, String averiaDescrip, String comentario, int usuarioID){
        // Buscar por ID
        try{
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();

            // Convertir las fechas a string
            String fechaReporteStr = fechaReporte.toString();
            String fechaReparacionStr = fechaReparacion.toString();

            // Construir la consulta UPDATE
            String query = "UPDATE Averia SET FechaReporte = '" + fechaReporteStr + 
            "', FechaReparacion = '" + fechaReparacionStr + 
            "', Duracion = " + duracion + 
            ", Coste = " + coste + 
            ", AveriaDescrip = '" + averiaDescrip + 
            "', Comentario = '" + comentario + 
            "', UsuarioID = " + usuarioID + 
            " WHERE AveriaID = " + ID;

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Modificación hecha con éxito. Filas afectadas: " + filasAfectadas);

            // Ver el resultado
            query = "SELECT * FROM Averia WHERE AveriaID = '" + ID + "'";
            ResultSet resultados = stmt.executeQuery(query);
            if(resultados.next()){
            System.out.println("La avería, en la base de datos, es: ");
            System.out.println("ID: " + resultados.getString("AveriaID"));
            System.out.println("Fecha de Reporte: " + resultados.getDate("FechaReporte"));
            System.out.println("Fecha de Reparación: " + resultados.getDate("FechaReparacion"));
            System.out.println("Duración: " + resultados.getInt("Duracion"));
            System.out.println("Coste: " + resultados.getDouble("Coste"));
            System.out.println("Descripción de la Avería: " + resultados.getString("AveriaDescrip"));
            System.out.println("Comentario: " + resultados.getString("Comentario"));
            System.out.println("UsuarioID: " + resultados.getInt("UsuarioID"));
            }

            }catch (SQLException e) {
                System.out.println("Error: No se pudo conectar a la base de datos.");
                e.printStackTrace();
            }
    }

    /**
     *
     * @param maquinaID
     * @param maquinaDescrip
     * @param tipo
     * @param ubicacion
     * @param horas
     * @param estado
     * @param fechaManten
     * @param responsableID
     */
    public void modificarMaquina(int maquinaID, String maquinaDescrip, String tipo, String ubicacion, int horas, boolean estado, Date fechaManten, int responsableID) {
        // Buscar por maquinaID
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();

            // Convertir la fecha a string
            String fechaMantenStr = fechaManten.toString();

            // Construir la consulta UPDATE
            String query = "UPDATE Maquina SET maquinaDescrip = '" + maquinaDescrip + 
                           "', tipo = '" + tipo + 
                           "', ubicacion = '" + ubicacion + 
                           "', horas = " + horas + 
                           ", estado = " + (estado ? 1 : 0) + 
                           ", fechaManten = '" + fechaMantenStr + 
                           "', usuarioID = " + responsableID + 
                           " WHERE maquinaID = " + maquinaID;

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Modificación hecha con éxito. Filas afectadas: " + filasAfectadas);

            // Ver el resultado
            query = "SELECT * FROM Maquina WHERE maquinaID = '" + maquinaID + "'";
            ResultSet resultados = stmt.executeQuery(query);
            if (resultados.next()) {
                System.out.println("La máquina, en la base de datos, es: ");
                System.out.println("ID: " + resultados.getString("maquinaID"));
                System.out.println("Descripción de la máquina: " + resultados.getString("maquinaDescrip"));
                System.out.println("Tipo: " + resultados.getString("tipo"));
                System.out.println("Ubicación: " + resultados.getString("ubicacion"));
                System.out.println("Horas de uso: " + resultados.getInt("horas"));
                System.out.println("Estado: " + (resultados.getInt("estado") == 1 ? "Activo" : "Inactivo"));
                System.out.println("Fecha de Mantenimiento: " + resultados.getDate("fechaManten"));
                System.out.println("ResponsableID: " + resultados.getInt("usuarioID"));
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param tareaID
     * @param tareaNombre
     * @param tareaDescrip
     */
    public void modificarTarea(int tareaID, String tareaNombre, String tareaDescrip) {
        // Buscar por tareaID y cambiar por los nuevos datos
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();

            // Construir la consulta UPDATE
            String query = "UPDATE Tarea SET TareaNombre = '" + tareaNombre + 
                           "', TareaDescrip = '" + tareaDescrip + 
                           "' WHERE TareaID = " + tareaID;

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Modificación hecha con éxito. Filas afectadas: " + filasAfectadas);

            // Ver el resultado
            query = "SELECT * FROM Tarea WHERE TareaID = " + tareaID;
            ResultSet resultados = stmt.executeQuery(query);
            if (resultados.next()) {
                System.out.println("La tarea, en la base de datos, es: ");
                System.out.println("ID: " + resultados.getString("TareaID"));
                System.out.println("Nombre de la tarea: " + resultados.getString("TareaNombre"));
                System.out.println("Descripción de la tarea: " + resultados.getString("TareaDescrip"));
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    
    //Métodos para eliminar

    /**
     *
     * @param ID
     */
    public void eliminarUsuario(int ID){
        try{
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String query ="delete from Usuario where usuarioID = " + ID;
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Eliminación hecha con éxito. Filas afectadas: " + filasAfectadas);
        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param averiaID
     */
    public void eliminarAveria(int averiaID) {
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String query = "DELETE FROM Averia WHERE AveriaID = " + averiaID;
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Eliminación hecha con éxito. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param maquinaID
     */
    public void eliminarMaquina(int maquinaID) {
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String query = "DELETE FROM Maquina WHERE maquinaID = " + maquinaID;
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Eliminación hecha con éxito. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param tareaID
     */
    public void eliminarTarea(int tareaID) {
        try {
            Connection c = conexion.getConection();
            java.sql.Statement stmt = c.createStatement();
            String query = "DELETE FROM Tarea WHERE TareaID = " + tareaID;
            int filasAfectadas = stmt.executeUpdate(query);
            System.out.println("Eliminación hecha con éxito. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }
    
    public int buscarUsuarioPorId(int idUsuario){

            Usuario usuario = null;
            int usuariosAfectados = 0;

            System.out.println("Entro en metodo buscarUsuarioPorId"); 

        try {

            Connection c = conexion.getConection(); 

            java.sql.Statement stmt = c.createStatement();

            String query = "select * "
            + " from Usuario where usuarioID ="+ idUsuario;

            ResultSet resultados = stmt.executeQuery(query);
            usuariosAfectados = resultados.getRow();
            System.out.println("Numero de usuarios afectados: "+ usuariosAfectados);

        } catch (SQLException e) { 

            System.out.println("Error: No se pudo conectar a la base de datos."); 

        e.printStackTrace(); 
        }
            return usuariosAfectados;
        }


}
