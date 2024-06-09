package persistencia;

import java.io.Serializable;

public class VehiculoDTO implements Serializable {
	private String patente;
    private boolean baul;
    private boolean petFriendly;
    private int maxPasajeros;
    private String tipo;
    
	public String getPatente() {
		return patente;
	}
	public boolean isBaul() {
		return baul;
	}
	public boolean isPetFriendly() {
		return petFriendly;
	}
	public int getMaxPasajeros() {
		return maxPasajeros;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public void setBaul(boolean baul) {
		this.baul = baul;
	}
	public void setPetFriendly(boolean petFriendly) {
		this.petFriendly = petFriendly;
	}
	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
    
    
}
