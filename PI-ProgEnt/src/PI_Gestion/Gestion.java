/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Gestion;

import PI_Tablas.*;
import java.util.Objects;
import java.beans.Statement;
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
    public void buscarUsuario(){
        Connection c = conexion.getConection();
    
    }
    public void buscarAveria(){}
    public void buscarMaquina(){}
    public void buscarTarea(){}
    
    //Métodos de listado
    public void listaUsuarios(){/*recorrer arrayList que toque*/}
    public void listaAverias(){}
    public void listaMaquinas(){}
    public void listaTareas(){}
    
    //Métodos de creación
    public void insertarUsuario(){/*cuidado con los ID, son autoincrementales*/}
    public void insertarAveria(){}
    public void insertarMaquina(){}
    public void insertarTarea(){}
    
    //Métodos para modificar
    public void modificarUsuario(){/*hacer paso guiado con Scanner, que modifique todo menos ID*/}
    public void modificarAveria(){}
    public void modificarMaquina(){}
    public void modificarTarea(){}
    
    //Métodos para eliminar
    public void eliminarUsuario(){ /*no te olvides el where ID es el que toca*/}
    public void eliminarAveria(){}
    public void eliminarMaquina(){}
    public void eliminarTarea(){}
}
