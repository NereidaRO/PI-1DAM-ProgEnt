/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PI_Tablas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/**
 * @since 03/04/2025
 * @author Diego Bermejo Álvarez, Ayman El Hattachi, Nereida Rodríguez Orenes - 1ºDAM
 * Proyecto Intermodular - Entornos de Desarrollo y Programación
 */
public class ReportaAveria {
    private Usuario reportador;
    private Maquina maquina;
    private Averia averia;
	
	//getters y setters

	public Usuario getReportador() {
		return reportador;
	}

	public void setReportador(Usuario reportador) {
		this.reportador = reportador;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Averia getAveria() {
		return averia;
	}

	public void setAveria(Averia averia) {
		this.averia = averia;
	}

	
	//hashcode y equals
	@Override
	public int hashCode() {
		return Objects.hash(averia, maquina, reportador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportaAveria other = (ReportaAveria) obj;
		return Objects.equals(averia, other.averia) && Objects.equals(maquina, other.maquina)
				&& Objects.equals(reportador, other.reportador);
	}

	
	//toString
	@Override
	public String toString() {
		return "ReportaAveria [reportador=" + reportador + ", maquina=" + maquina + ", averia=" + averia + "]";
	}

	
	//Constructores
	public ReportaAveria(Usuario reportador, Maquina maquina, Averia averia) {
		super();
		this.reportador = reportador;
		this.maquina = maquina;
		this.averia = averia;
	}

	//Constructores sin parámetros
	public ReportaAveria() {
		super();
		this.reportador = reportador;
		this.maquina = maquina;
		this.averia = averia;
	}
	
	public void imprimirReporte(String ruta, String nombreFichero) {
		try{ 

	        FileWriter fw = new FileWriter(ruta + nombreFichero); 

	        BufferedWriter bw = new BufferedWriter(fw); 

	        bw.write("Reporta avería: "); 

	        bw.newLine(); 

	        bw.write("Máquina: "); 

	        bw.write(this.maquina.toString()); 

	        bw.newLine(); 

	        bw.write("Avería: "); 

	        bw.write(this.averia.toString()); 

	        bw.newLine(); 

	        bw.write("Usuario:"); 
	        
	        bw.write(this.reportador.toString()); 

	        bw.newLine(); 

	        bw.close(); 

	        fw.close(); 

	        }catch(IOException ioe){ 

	            System.out.println(ioe); 

	        } 
	}
    
}

