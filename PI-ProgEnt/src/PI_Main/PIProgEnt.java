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
 * Dentro de cada opción, habrá otro menú para pedir la gestión concreta (creación, modificación, etc.).
 * Después de cada gestión, el programa se cierra. En el futuro, se podría hacer recursivo.
 */
public class PIProgEnt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        Gestion gest = new Gestion();
        // Menú inicial:
        System.out.println("Hola, ¿qué tipo de gestión quiere hacer? \n"
                + "1 - Gestionar usuarios \n"
                + "2 - Gestionar máquinas \n"
                + "3 - Gestionar averías \n"
                + "4 - Gestionar tareas \n"
                + "0 - Salir \n"
        );
        opt = sc.nextInt();
        sc.nextLine();
        while (opt!=0){
            switch(opt){
                case 1:
                    //Submenú usuario
                    System.out.println("Gestión de usuarios: \n"
                            + "1 - Crear usuario \n"
                            + "2 - Modificar usuario \n"
                            + "3 - Buscar usuario por ID \n"
                            + "4 - Ver todos los usuarios \n"
                            + "5 - Eliminar usuario \n"
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
                            NIF = sc.nextLine();
                            System.out.println("Escriba el nombre (JoseAntonio): ");
                            nombre = sc.nextLine();
                            System.out.println("Escriba los apellidos (GarciaGomez): ");
                            apellidos = sc.nextLine();
                            System.out.println("Escriba la dirección: ");
                            direccion = sc.nextLine();
                            System.out.println("Escriba el email: ");
                            email = sc.nextLine();
                            System.out.println("Escriba el rol (admin, operario, mecanico): ");
                            rol = sc.nextLine();
                            System.out.println("Escriba la fecha de nacimiento (aaaa-mm-dd): ");
                            fechaNacim = java.sql.Date.valueOf(sc.nextLine());  
                            
                            gest.insertarUsuario(NIF, nombre, apellidos, direccion, email, rol, fechaNacim);
                            
                            opt=0;
                            break;
                        case 2:
                            int userID;
                            //El resto de las variables están en case 1; Java entiende que son para todos los casos
                            System.out.println("Escriba el ID del usuario en la base de datos: ");
                            userID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el NIF: ");
                            NIF = sc.nextLine();
                            System.out.println("Escriba el nombre (JoseAntonio): ");
                            nombre = sc.nextLine();
                            System.out.println("Escriba los apellidos (GarciaGomez): ");
                            apellidos = sc.nextLine();
                            System.out.println("Escriba la dirección: ");
                            direccion = sc.nextLine();
                            System.out.println("Escriba el email: ");
                            email = sc.nextLine();
                            System.out.println("Escriba el rol (admin, operario, mecanico): ");
                            rol = sc.nextLine();
                            System.out.println("Escriba la fecha de nacimiento (aaaa-mm-dd): ");
                            fechaNacim = java.sql.Date.valueOf(sc.nextLine()); 
                            
                            gest.modificarUsuario(userID, NIF, nombre, apellidos, direccion, email, rol, fechaNacim);
                            
                            opt=0;
                            break;
                        case 3:
                            System.out.println("Escriba el ID del usuario que busca: ");
                            int idUsuario = sc.nextInt();
                            sc.nextLine();
                            gest.buscarUsuario(idUsuario);
                            opt=0;
                            break;
                        case 4:
                            gest.listaUsuarios();
                            opt=0;
                            break;
                        case 5:
                            System.out.println("Escriba el ID del usuario que quiere eliminar: ");
                            userID = sc.nextInt();
                            sc.nextLine();
                            gest.eliminarUsuario(userID);
                            opt=0;
                            break;
                    }
                    break;
                case 2:
                    //Submenú máquinas
                    System.out.println("Gestión de máquinas: \n"
                            + "1 - Crear máquina \n"
                            + "2 - Modificar máquina \n"
                            + "3 - Buscar máquina por ID \n"
                            + "4 - Ver todas las máquinas \n"
                            + "5 - Eliminar máquina \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            
                            String maquinaDescrip;
                            String tipo;
                            String ubicacion;
                            int horas;
                            boolean status;
                            int responsableID;
                            java.sql.Date fechaManten;
                            
                            System.out.println("Escriba una descripción breve: ");
                            maquinaDescrip = sc.nextLine();
                            System.out.println("Escriba el tipo de máquina: ");
                            tipo = sc.nextLine();
                            System.out.println("Escriba la ubicación: ");
                            ubicacion = sc.nextLine();
                            System.out.println("Escriba cuántas horas de uso tiene: ");
                            horas = sc.nextInt();
                            sc.nextLine();
                            //Por defecto, las máquinas nuevas están activas (no deberían estar rotas si son nuevas)
                            status = true;
                            System.out.println("Escriba la fecha del próximo mantenimiento (aaaa-mm-dd): ");
                            fechaManten = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba el ID del responsable: ");
                            responsableID = sc.nextInt();
                            sc.nextLine();
                            
                            gest.insertarMaquina(maquinaDescrip, tipo, ubicacion, horas, status, fechaManten, responsableID);
                            
                            opt=0;
                            break;
                        case 2:
                            int maqID;
                            String aux;
                            
                            System.out.println("Escriba el ID de la máquina que quiere modificar: ");
                            maqID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba una descripción breve: ");
                            maquinaDescrip = sc.nextLine();
                            System.out.println("Escriba el tipo de máquina: ");
                            tipo = sc.nextLine();
                            System.out.println("Escriba la ubicación: ");
                            ubicacion = sc.nextLine();
                            System.out.println("Escriba cuántas horas de uso tiene: ");
                            horas = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba 'r' si la máquina está rota y otra letra si está activa");
                            aux = sc.nextLine();
                            if (aux == "r"){
                                status = false;
                            }else{
                                status = true;
                            }
                            System.out.println("Escriba la fecha del próximo mantenimiento (aaaa-mm-dd): ");
                            fechaManten = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba el ID del responsable: ");
                            responsableID = sc.nextInt();
                            sc.nextLine();
                            
                            gest.modificarMaquina(maqID, maquinaDescrip, tipo, ubicacion, horas, status, fechaManten, responsableID);
                            
                            opt=0;
                            break;
                        case 3:
                            System.out.println("Escriba el ID de la máquina que busca: ");
                            int idMaquina = sc.nextInt();
                            sc.nextLine();
                            gest.buscarUsuario(idMaquina);
                            opt=0;
                            break;
                        case 4:
                            gest.listaMaquinas();
                            opt=0;
                            break;
                        case 5:
                            System.out.println("Escriba el ID de la máquina que quiere eliminar: ");
                            maqID = sc.nextInt();
                            sc.nextLine();
                            gest.eliminarMaquina(maqID);
                            opt=0;
                            break;
                    }
                    break;
                case 3:
                    //Submenú averías
                    System.out.println("Gestión de averías: \n"
                            + "1 - Reportar avería \n"
                            + "2 - Modificar avería \n"
                            + "3 - Buscar avería por ID \n"
                            + "4 - Ver todas las averías \n"
                            + "5 - Eliminar averia \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            java.sql.Date fechaReporte;
                            java.sql.Date fechaReparacion;
                            int duracion; 
                            int coste;
                            String averiaDescrip;
                            String comentario;
                            int usuarioID;
                            
                            System.out.println("Escriba la fecha de reporte (aaaa-mm-dd): ");
                            fechaReporte = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba la fecha de reparacion (aaaa-mm-dd): ");
                            fechaReparacion = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba cuántas horas estuvo parada la máquina: ");
                            duracion = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el coste de la avería: ");
                            coste = sc.nextInt(); 
                            sc.nextLine();
                            System.out.println("Escriba una descripción breve: ");
                            averiaDescrip = sc.nextLine();
                            System.out.println("Escriba un comentario: ");
                            comentario = sc.nextLine();
                            //Aunque esto sea redundante, no poner el reportador da conflictos con la base de datos
                            System.out.println("Escriba quien reportó la avería: ");
                            usuarioID = sc.nextInt();
                            sc.nextLine();
                            
                            gest.insertarAveria(fechaReporte, fechaReparacion, duracion, coste, averiaDescrip, comentario, usuarioID);
                            
                            opt=0;
                            break;
                        case 2:
                            //code
                            int avID;
                            System.out.println("Escriba el ID de la avería que quiere modificar: ");
                            avID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba la fecha de reporte (aaaa-mm-dd): ");
                            fechaReporte = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba la fecha de reparacion (aaaa-mm-dd): ");
                            fechaReparacion = java.sql.Date.valueOf(sc.nextLine()); 
                            System.out.println("Escriba cuántas horas estuvo parada la máquina: ");
                            duracion = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el coste de la avería: ");
                            coste = sc.nextInt(); 
                            sc.nextLine();
                            System.out.println("Escriba una descripción breve: ");
                            averiaDescrip = sc.nextLine();
                            System.out.println("Escriba un comentario: ");
                            comentario = sc.nextLine();
                            //Aunque esto sea redundante, no poner el reportador da conflictos con la base de datos
                            System.out.println("Escriba quien reportó la avería: ");
                            usuarioID = sc.nextInt();
                            sc.nextLine();
                            
                            gest.modificarAveria(avID, fechaReporte, fechaReparacion, duracion, coste, averiaDescrip, comentario, usuarioID);
                            
                            opt=0;
                            break;
                        case 3:
                            //code
                            System.out.println("Escriba el ID de la avería que busca: ");
                            avID = sc.nextInt();
                            sc.nextLine();
                            gest.buscarAveria(avID);
                            opt=0;
                            break;
                        case 4:
                            gest.listaAverias();
                            opt=0;
                            break;
                        case 5:
                            System.out.println("Escriba el ID de la avería que quiere eliminar: ");
                            avID = sc.nextInt();
                            sc.nextLine();
                            gest.eliminarAveria(avID);
                            opt=0;
                            break;
                    }
                    break;
                case 4:
                    //Submenú tareas
                    System.out.println("Gestión de tareas: \n"
                            + "1 - Crear tarea \n"
                            + "2 - Modificar tarea \n"
                            + "3 - Buscar tarea por ID \n"
                            + "4 - Ver todas las tareas \n"
                            + "5 - Eliminar tarea \n"
                            + "6 - Asignar tarea \n"
                            + "0 - Salir \n"
                    );
                    opt = sc.nextInt();
                    switch(opt){
                        case 1:
                            String tareaNombre;
                            String tareaDescrip;

                            System.out.println("Escriba el nombre de la tarea: ");
                            tareaNombre = sc.nextLine();
                            System.out.println("Escriba una descripción breve: ");
                            tareaDescrip = sc.nextLine();

                            gest.insertarTarea(tareaNombre, tareaDescrip);
                            
                            opt=0;
                            break;
                        case 2:
                            //code
                            int tareaID;
                            
                            System.out.println("Escriba el ID de la tarea que quiere modificar: ");
                            tareaID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Escriba el nombre de la tarea: ");
                            tareaNombre = sc.nextLine();
                            System.out.println("Escriba una descripción breve: ");
                            tareaDescrip = sc.nextLine();
                            
                            opt=0;
                            break;
                        case 3:
                            System.out.println("Escriba el ID de la tarea que busca: ");
                            int idTarea = sc.nextInt();
                            sc.nextLine();
                            gest.buscarTarea(idTarea);
                            opt=0;
                            break;
                        case 4:
                            gest.listaTareas();
                            opt=0;
                            break;
                        case 5:
                            System.out.println("Escriba el ID de la tarea que quiere eliminar: ");
                            tareaID = sc.nextInt();
                            sc.nextLine();
                            gest.eliminarTarea(tareaID);
                            opt=0;
                            break;
                        case 6:
                            //code
                            opt=0;
                            break;
                    }
                    break;
                default:
                    //Cualquier otra opción cierra el programa
                    opt = 0;
            }
        }
        System.out.println("Ha salido del programa, que pase un buen día");
    }
}
