/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Tarea {
    private int tareaID;
    private String tareaNombre;
    private String tareaDescrip;
  
    //Constructores con parámetros
	public Tarea(int tareaID, String tareaNombre, String tareaDescrip) {
		super();
		this.tareaID = tareaID;
		this.tareaNombre = tareaNombre;
		this.tareaDescrip = tareaDescrip;
	}
    
	//Constructores sin parámetros
	public Tarea() {
		super();
		tareaID = 0;
		tareaNombre = " ";
		tareaDescrip = " ";
	}

	//Getters y setters

    /**
     *
     * @return int
     */
	public int getTareaID() {
		return tareaID;
	}

    /**
     *
     * @param tareaID
     */
    public void setTareaID(int tareaID) {
		this.tareaID = tareaID;
	}

    /**
     *
     * @return String
     */
    public String getTareaNombre() {
		return tareaNombre;
	}

    /**
     *
     * @param tareaNombre
     */
    public void setTareaNombre(String tareaNombre) {
		this.tareaNombre = tareaNombre;
	}

    /**
     *
     * @return String
     */
    public String getTareaDescrip() {
		return tareaDescrip;
	}

    /**
     *
     * @param tareaDescrip
     */
    public void setTareaDescrip(String tareaDescrip) {
		this.tareaDescrip = tareaDescrip;
	}

	
	//toString

    /**
     *
     * @return String
     */
	@Override
	public String toString() {
		return "Tarea [tareaID=" + tareaID + ", tareaNombre=" + tareaNombre + ", tareaDescrip=" + tareaDescrip + "]";
	}

	
	
	//Hashcode y equals

    /**
     *
     * @return int
     */
	@Override
	public int hashCode() {
		return Objects.hash(tareaDescrip, tareaID, tareaNombre);
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
		Tarea other = (Tarea) obj;
		return Objects.equals(tareaDescrip, other.tareaDescrip) && tareaID == other.tareaID
				&& Objects.equals(tareaNombre, other.tareaNombre);
	}
}
