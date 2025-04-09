/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PI_Main;
import PI_Gestion.*;
import PI_Tablas.*;
import java.sql.Date;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        Gestion gest = new Gestion();
        //gest.insertarAveria(Date.valueOf("2025-03-08"), Date.valueOf("2025-04-08"), 1, 3000, "Cuchilla rota", "Buscar otro proveedor", 3);
        //gest.insertarMaquina("Maquina QRT", "fresadora", "modulo 3", 2500, true, Date.valueOf("2025-06-08"), 5);
        //gest.insertarTarea("Reparar tabletas", "Reparar el soporte de esta aplicacion");
        //gest.eliminarTarea(27);
        //gest.modificarAveria(3, Date.valueOf("2025-03-08"), Date.valueOf("2025-04-08"), 2, 500, "Torno derretido", "Sin comentarios", 5);
        //gest.modificarMaquina(6, "Maquina SSD", "Apiladora", "modulo 15", 150, true, Date.valueOf("2025-07-08"), 7);
        gest.modificarTarea(4, "Afilar", "Afilar las cuchillas de las máquinas de corte");
        // Menú inicial:
        /*System.out.println("Hola, ¿qué tipo de gestión quiere hacer? \n"
                + "1 - Gestionar usuarios \n"
                + "2 - Gestionar máquinas \n"
                + "3 - Gestionar averías \n"
                + "4 - Gestionar tareas \n"
                + "0 - Salir \n"
        );
        opt = sc.nextInt();
        while (opt!=0){
            //switch: un submenú por gestión
            //NOTA: hay que dar la opción de que opt se cambie a 0;
            switch(opt){
                case 1:
                    System.out.println("Gestión de usuarios: \n"
                            + "1 - Crear usuario \n"
                            + "2 - Modificar usuario \n"
                            + "3 - Buscar usuario por ID \n"
                            + "4 - Ver todos los usuarios \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    
                    switch(opt){
                        case 1:
                            String NIF;
                            String nombre;
                            String apellidos;
                            String direccion;
                            String email;
                            String rol;
                            java.sql.Date fechaNacim;
                            
                            System.out.println("Escriba el NIF: ");
                            NIF = sc.next();
                            System.out.println("Escriba el nombre (JoseAntonio): ");
                            nombre = sc.next();
                            System.out.println("Escriba los apellidos (GarciaGomez): ");
                            apellidos = sc.next();
                            System.out.println("Escriba la dirección: ");
                            direccion = sc.next();
                            System.out.println("Escriba el email: ");
                            email = sc.next();
                            System.out.println("Escriba el rol (admin, operario, mecanico): ");
                            rol = sc.next();
                            System.out.println("Escriba la fecha de nacimiento (aaaa-mm-dd): ");
                            fechaNacim = java.sql.Date.valueOf(sc.next());  
                            
                            gest.insertarUsuario(NIF, nombre, apellidos, direccion, email, rol, fechaNacim);
                            
                            break;
                        case 2:
                            //code
                            break;
                        case 3:
                            System.out.println("Escriba el ID del usuario que busca: ");
                            int idUsuario = sc.nextInt();
                            gest.buscarUsuario(idUsuario);
                            opt=0;
                            break;
                        case 4:
                            //code
                            break;
                    }
                    
                    break;
                case 2:
                    System.out.println("Gestión de máquinas: \n"
                            + "1 - Crear máquina \n"
                            + "2 - Modificar máquina \n"
                            + "3 - Buscar máquina por ID \n"
                            + "4 - Ver todas las máquinas \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            //code
                            break;
                        case 2:
                            //code
                            break;
                        case 3:
                            System.out.println("Escriba el ID de la máquina que busca: ");
                            int idMaquina = sc.nextInt();
                            gest.buscarUsuario(idMaquina);
                            opt=0;
                            break;
                        case 4:
                            //code
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Gestión de averías: \n"
                            + "1 - Reportar avería \n"
                            + "2 - Modificar avería \n"
                            + "3 - Buscar avería por ID \n"
                            + "4 - Ver todas las averías \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            //code
                            break;
                        case 2:
                            //code
                            break;
                        case 3:
                            //code
                            break;
                        case 4:
                            gest.listaAverias();
                            opt=0;
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Gestión de tareas: \n"
                            + "1 - Crear tarea \n"
                            + "2 - Modificar tarea \n"
                            + "3 - Buscar tarea por ID \n"
                            + "4 - Ver todas las tareas \n"
                            + "5 - Asignar tarea \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            //code
                            break;
                        case 2:
                            //code
                            break;
                        case 3:
                            System.out.println("Escriba el ID de la tarea que busca: ");
                            int idTarea = sc.nextInt();
                            gest.buscarTarea(idTarea);
                            opt=0;
                            break;
                        case 4:
                            gest.listaTareas();
                            opt=0;
                            break;
                    }
                    break;
                default:
                    opt = 0;
            }
        }
        System.out.println("Ha salido del programa, que pase un buen día");*/
    }
}
