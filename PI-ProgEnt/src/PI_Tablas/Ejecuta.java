/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.util.ArrayList;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Ejecuta {
    private ArrayList<Usuario> ejecutor;
    private Maquina maquina;
    private Tarea tarea;

    public Ejecuta() {}
    
    public Ejecuta(Maquina maquina, Tarea tarea){
        this.maquina = maquina;
        this.tarea = tarea;
        this.ejecutor = new ArrayList<Usuario>();
    }
    //Como los usuarios pueden ser uno o más, es conveniente que el administrador asigne una tarea en dos pasos: crearla y asignarla.
    public void assignUser(Usuario usuario){
        //El/los usuarios a los que se asigna la tarea ya están creados
        //Esta función añade 1 usuario, pero se gestiona su repetición con un menú en Main
        this.ejecutor.add(usuario);
    }
    
    
}
