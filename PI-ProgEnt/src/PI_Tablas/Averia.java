/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;
import java.sql.Date; 
import java.util.Objects;
/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Averia {
    //Variables
private int averiaID;
private Date FechaReporte;
private Date fechaReparacion;
private int duracion;
private int coste;
private String averiaDescrip;
private String comentario;
private int reportador;

//Metodos get y set de las variables
public int getAveriaID() {

    return averiaID;
}
public Date getFechaReporte() {
    return FechaReporte;
}
public void setFechaReporte(Date fechaReporte) {
    FechaReporte = fechaReporte;
}
public Date getFechaReparacion() {
    return fechaReparacion;
}
public void setFechaReparacion(Date fechaReparacion) {
    this.fechaReparacion = fechaReparacion;
}
public float getDuracion() {
    return duracion;
}
public void setDuracion(int duracion) {
    this.duracion = duracion;
}
public int getCoste() {
    return coste;
}
public void setCoste(int coste) {
    this.coste = coste;
}
public String getAveriaDescrip() {
    return averiaDescrip;
}
public void setAveriaDescrip(String averiaDescrip) {
    this.averiaDescrip = averiaDescrip;
}
public String getComentario() {
    return comentario;
}
public void setComentario(String comentario) {
    this.comentario = comentario;
}

public int getReportador() {
    return reportador;
}

public void setReportador(int reportador) {
    this.reportador = reportador;
}

//Constructores de la clase
public Averia(int averiaID, Date fechaReporte, Date fechaReparacion, int duracion, int coste,
        String averiaDescrip, String comentario, int userID) {
    
    this.averiaID = averiaID;
    this.FechaReporte = fechaReporte;
    this.fechaReparacion = fechaReparacion;
    this.duracion = duracion;
    this.coste = coste;
    this.averiaDescrip = averiaDescrip;
    this.comentario = comentario;
    this.reportador = userID;
}

public Averia() {
    
    this.averiaID = 0;
    this.duracion = 0;
    this.coste = 0;
    this.averiaDescrip = "";
    this.comentario = "";
}

//Metodos hashCode y equals para comparar averias
@Override
public int hashCode() {
    return Objects.hash(FechaReporte, averiaDescrip, averiaID, comentario, coste, duracion, fechaReparacion);
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Averia other = (Averia) obj;
    return Objects.equals(FechaReporte, other.FechaReporte) && Objects.equals(averiaDescrip, other.averiaDescrip)
            && averiaID == other.averiaID && Objects.equals(comentario, other.comentario) && coste == other.coste
            && Float.floatToIntBits(duracion) == Float.floatToIntBits(other.duracion)
            && Objects.equals(fechaReparacion, other.fechaReparacion);
}

//Metodo toString
@Override
public String toString() {
    return "Averia [averiaID=" + averiaID + ", FechaReporte=" + FechaReporte + ", fechaReparacion="
            + fechaReparacion + ", duracion=" + duracion + ", coste=" + coste + ", averiaDescrip=" + averiaDescrip
            + ", comentario=" + comentario + "]";
}

}
