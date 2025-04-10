/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.util.Date;
import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class Maquina {
    private int maquinaID;
    private String maquinaDescrip;
    private String tipo;
    private String ubicacion;
    private int horas;
    private boolean estado;
    private Date fechaManten;
    private int responsableID;
	
    
    //Constructores con parámetros
    public Maquina(int maquinaID, String maquinaDescrip, String tipo, String ubicacion, int horas, boolean estado,
			Date fechaManten, int responsableID) {
		super();
		this.maquinaID = maquinaID;
		this.maquinaDescrip = maquinaDescrip;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.horas = horas;
		this.estado = estado;
		this.fechaManten = fechaManten;
		this.responsableID = responsableID;
	}

    //Constructores sin parámetros
	public Maquina() {
		super();
		maquinaID = 0;
		maquinaDescrip = " ";
		tipo = " ";
		ubicacion = " ";
		horas = 0;
		estado = true;
		responsableID = 0;
	}



	//getters y setters

    /**
     *
     * @return int
     */
	public int getMaquinaID() {
		return maquinaID;
	}

    /**
     *
     * @param maquinaID
     */
    public void setMaquinaID(int maquinaID) {
		this.maquinaID = maquinaID;
	}

    /**
     *
     * @return String
     */
    public String getMaquinaDescrip() {
		return maquinaDescrip;
	}

    /**
     *
     * @param maquinaDescrip
     */
    public void setMaquinaDescrip(String maquinaDescrip) {
		this.maquinaDescrip = maquinaDescrip;
	}

    /**
     *
     * @return String
     */
    public String getTipo() {
		return tipo;
	}

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    /**
     *
     * @return String
     */
    public String getUbicacion() {
		return ubicacion;
	}

    /**
     *
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

    /**
     *
     * @return int
     */
    public int getHoras() {
		return horas;
	}

    /**
     *
     * @param horas
     */
    public void setHoras(int horas) {
		this.horas = horas;
	}

    /**
     *
     * @return boolean
     */
    public boolean isEstado() {
		return estado;
	}

    /**
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
		this.estado = estado;
	}

    /**
     *
     * @return Date
     */
    public Date getFechaManten() {
		return fechaManten;
	}

    /**
     *
     * @param fechaManten
     */
    public void setFechaManten(Date fechaManten) {
		this.fechaManten = fechaManten;
	}

    /**
     *
     * @return int
     */
    public int getResponsableID() {
		return responsableID;
	}

    /**
     *
     * @param responsableID
     */
    public void setResponsableID(int responsableID) {
		this.responsableID = responsableID;
	}

	//toString

    /**
     *
     * @return String
     */
	@Override
	public String toString() {
		return "Maquina [maquinaID=" + maquinaID + ", maquinaDescrip=" + maquinaDescrip + ", tipo=" + tipo
				+ ", ubicacion=" + ubicacion + ", horas=" + horas + ", estado=" + estado + ", fechaManten="
				+ fechaManten + ", responsableID=" + responsableID + "]";
	}


	//hashcode y equals

    /**
     *
     * @return int
     */
	@Override
	public int hashCode() {
		return Objects.hash(estado, fechaManten, horas, maquinaDescrip, maquinaID, responsableID, tipo, ubicacion);
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
		Maquina other = (Maquina) obj;
		return estado == other.estado && Objects.equals(fechaManten, other.fechaManten) && horas == other.horas
				&& Objects.equals(maquinaDescrip, other.maquinaDescrip) && maquinaID == other.maquinaID
				&& responsableID == other.responsableID && Objects.equals(tipo, other.tipo)
				&& Objects.equals(ubicacion, other.ubicacion);
	}

}

