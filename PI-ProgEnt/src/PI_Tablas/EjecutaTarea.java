/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 * Esta clase sirve para asignar tareas a los usuarios e imprimir informes
 */
public class EjecutaTarea {
    private ArrayList<Usuario> ejecutor;
    private Maquina maquina;
    private Tarea tarea;

    public EjecutaTarea() {}
    
    public EjecutaTarea(Maquina maquina, Tarea tarea){
        this.maquina = maquina;
        this.tarea = tarea;
        this.ejecutor = new ArrayList<Usuario>();
    }
    //Como los usuarios pueden ser uno o más, es conveniente que el administrador asigne una tarea en dos pasos: crearla y asignarla.

    /**
     *
     * @param usuario Usuario
     */
    public void assignUser(Usuario usuario){
        //El/los usuarios a los que se asigna la tarea ya están creados
        //Esta función añade 1 usuario, pero se gestiona su repetición con un menú en Main
        this.ejecutor.add(usuario);
    }

    /**
     *
     * @return Maquina
     */
    public Maquina getMaquina() {
        return maquina;
    }

    /**
     *
     * @param maquina Maquina
     */
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    /**
     *
     * @return Tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     *
     * @param tarea Tarea
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    /**
     *
     * @return ArrayList Usuario
     */
    public ArrayList<Usuario> getEjecutor() {
        return ejecutor;
    }
    
    //Para ver, de manera legible, lo que hay en un ArrayList se imprime el contenido; el getter en sí saca el código interno de Java.

    /**
     * Mensaje por consola
     */
    public void getAssigned(){
        //recorrer la colección haciendo toString de cada elemento
        Iterator<Usuario> iterador = this.ejecutor.iterator();
        System.out.println("La tarea " + "this.tarea.getID()" + " tiene estos trabajadores asignados: ");
        while (iterador.hasNext()){
            System.out.println(iterador.next().toString());
        }
    }

    /**
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ejecutor);
        hash = 97 * hash + Objects.hashCode(this.maquina);
        hash = 97 * hash + Objects.hashCode(this.tarea);
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
        final EjecutaTarea other = (EjecutaTarea) obj;
        if (!Objects.equals(this.ejecutor, other.ejecutor)) {
            return false;
        }
        if (!Objects.equals(this.maquina, other.maquina)) {
            return false;
        }
        return Objects.equals(this.tarea, other.tarea);
    }

    /**
     *
     * @return String y mensaje
     */
    @Override
    public String toString() {
        Iterator<Usuario> iterador = this.ejecutor.iterator();
        //imprimir por pantalla los datos, de manera legible
        System.out.println("Maquina: " + this.maquina.toString());
        System.out.println("Tarea: " + this.tarea.toString());
        while (iterador.hasNext()){
            System.out.println("Usuario(s): " + iterador.next().toString());
        }
        
        //retornar un string (para otros procesos que necesiten este dato)
        return "Ejecuta{" + "ejecutor=" + this.ejecutor + ", maquina=" + this.maquina + ", tarea=" + this.tarea + '}';
    }
    
    //imprimir el informe (documento)

    /**
     *
     * @param ruta
     * @param nombreFichero
     * @return fichero
     */
     public void informeEjecucion(String ruta, String nombreFichero){
        try{
        Iterator<Usuario> iterador = this.ejecutor.iterator();
        FileWriter fw = new FileWriter(ruta + nombreFichero);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Informe de ejecución de tarea: ");
        bw.newLine();
        bw.write("Máquina: ");
        bw.write(this.maquina.toString());
        bw.newLine();
        bw.write("Tarea: ");
        bw.write(this.tarea.toString());
        bw.newLine();
        bw.write("Usuario(s)");
        bw.newLine();
        while (iterador.hasNext()){
            bw.write(iterador.next().toString());
            bw.newLine();
        }
        bw.close();
        fw.close();
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
}
