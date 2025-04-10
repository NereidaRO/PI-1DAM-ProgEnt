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
 */
public class ReparaAveria {
    //Variables
ArrayList<Usuario> usuarios = new ArrayList<>();
private Maquina maquina;
private Averia averia;

//Metodos get y set de las variables

    /**
     *
     * @param usuario
     */
public void setUsuarios(Usuario usuario) {
this.usuarios.add(usuario);
}

    /**
     *
     * @return obj
     */
    public Maquina getMaquina() {
        return maquina;
    }

    /**
     *
     * @param maquina
     */
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    /**
     *
     * @return obj
     */
    public Averia getAveria() {
        return averia;
    }

    /**
     *
     * @param averia
     */
    public void setAveria(Averia averia) {
        this.averia = averia;
    }


//Constructores de la clase
public ReparaAveria(Maquina maquina, Averia averia) {
this.usuarios = new ArrayList<Usuario>();
this.maquina = maquina;
this.averia = averia;
}

public ReparaAveria() {

this.maquina = maquina;
this.averia = averia;
}


//Metodos hashCode y equals

    /**
     *
     * @return int
     */
@Override
public int hashCode() {
    return Objects.hash(averia, maquina, usuarios);
}

    /**
     *
     * @param obj
     * @return boolean
     */
    @Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
ReparaAveria other = (ReparaAveria) obj;
return Objects.equals(averia, other.averia) && Objects.equals(maquina, other.maquina)
&& Objects.equals(usuarios, other.usuarios);
}

    /**
     *
     * @param ruta
     * @param nombreFichero
     */
    public void imprimirReparacion(String ruta, String nombreFichero) {
        try{ 
         Iterator<Usuario> iterador = this.usuarios.iterator(); 
         FileWriter fw = new FileWriter(ruta + nombreFichero); 
         BufferedWriter bw = new BufferedWriter(fw); 
         bw.write("Informe de reparación de avería: "); 
         bw.newLine(); 
         bw.write("Máquina: "); 
         bw.write(this.maquina.toString()); 
         bw.newLine(); 
         bw.write("Averia: "); 
         bw.write(this.averia.toString()); 
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
