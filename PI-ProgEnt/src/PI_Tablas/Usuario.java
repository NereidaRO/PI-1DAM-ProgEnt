/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Usuario {
    //Variables
private int usuarioID;
private String NIF;
private String nombre;
private String apellidos;
private String direccion;
private String email;
private String rol;
private Date fechaNacim;

//Metodos get y set de las variables
public int getUsuarioID() {
return usuarioID;
}
public String getNIF() {
return NIF;
}
public void setNIF(String nIF) {
NIF = nIF;
}
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}

public String getApellidos() {
    return apellidos;
}

public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}

public String getDireccion() {
return direccion;
}
public void setDireccion(String direccion) {
this.direccion = direccion;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getRol() {
return rol;
}
public void setRol(String rol) {
this.rol = rol;
}
public Date getFechaNacim() {
return fechaNacim;
}
public void setFechaNacim(Date fechaNacim) {
this.fechaNacim = fechaNacim;
}

//Constructores de la clase
public Usuario(int usuarioID, String nIF, String nombre,String apellidos, String direccion, String email, String rol,
Date fechaNacim) {

this.usuarioID = usuarioID;
this.NIF = nIF;
this.nombre = nombre;
this.apellidos = apellidos;
this.direccion = direccion;
this.email = email;
this.rol = rol;
this.fechaNacim = fechaNacim;
}

public Usuario() {

this.usuarioID = 0;
this.NIF = "";
this.nombre = "";
this.apellidos="";
this.direccion = "";
this.email = "";
this.rol = "";
}

//Metodos hashCode y equals para comparar usuarios
@Override
public int hashCode() {
return Objects.hash(NIF, direccion, email, fechaNacim, nombre, apellidos, rol, usuarioID);
}

@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Usuario other = (Usuario) obj;
return Objects.equals(NIF, other.NIF) && Objects.equals(direccion, other.direccion)
&& Objects.equals(email, other.email) && Objects.equals(fechaNacim, other.fechaNacim)
&& Objects.equals(nombre, other.nombre) && Objects.equals(rol, other.rol) && Objects.equals(apellidos, other.apellidos)
&& usuarioID == other.usuarioID;
}

//Metodo toString
@Override
public String toString() {
return "Usuario [usuarioID=" + usuarioID + ", NIF=" + NIF + ", nombre=" + nombre + ", apellidos: " + apellidos + ", direccion=" + direccion
+ ", email=" + email + ", rol=" + rol + ", fechaNacim=" + fechaNacim + "]";
}

}
