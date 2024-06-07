package persistencia;

import java.io.Serializable;

public class ChoferDTO implements Serializable {
	private String DNI;
    private String nombre;
    private int puntos;
    private int viajesMes;
    private double KMrecorridosMes;
    
    private double sueldoBasico;
    private int aportes;
    private int cantViajes;
    
    private double sueldobasico;
    private int antiguedad;
    private int cantHijos;
    private int anioIngreso;
    
    private int gananciaViaje;
    
	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public int getAportes() {
		return aportes;
	}

	public int getCantViajes() {
		return cantViajes;
	}

	public double getSueldobasico() {
		return sueldobasico;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public int getGananciaViaje() {
		return gananciaViaje;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public void setAportes(int aportes) {
		this.aportes = aportes;
	}

	public void setCantViajes(int cantViajes) {
		this.cantViajes = cantViajes;
	}

	public void setSueldobasico(double sueldobasico) {
		this.sueldobasico = sueldobasico;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public void setGananciaViaje(int gananciaViaje) {
		this.gananciaViaje = gananciaViaje;
	}

	public String getDNI() {
		return DNI;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public int getViajesMes() {
		return viajesMes;
	}
	
	public double getKMrecorridosMes() {
		return KMrecorridosMes;
	}
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void setViajesMes(int viajesMes) {
		this.viajesMes = viajesMes;
	}
	
	public void setKMrecorridosMes(double kMrecorridosMes) {
		KMrecorridosMes = kMrecorridosMes;
	}
}
