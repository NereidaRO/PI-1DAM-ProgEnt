/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PI_Main;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 * La idea de esta aplicación es que Main gestione los menús de cara al usuario, mientras que Gestion y Conexion se encarguen
 * del movimiento de datos.
 * Un primer menú evaluará hacia qué tipo de gestiones se dirige el usuario (máquinas, tareas, averías o usuarios).
 * Dentro de cada opción, habrá otro menú para pedir la gestión concreta (creación, modificación)
 */
public class PIProgEnt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Aquí van los menús
        System.out.println("Hola, ¿qué tipo de gestión quiere hacer? \n"
                + "1 - Gestionar usuarios"
                + "2 - Gestionar máquinas"
                + "3 - Gestionar averías"
                + ""
        );
    }
}
