package clases;
import java.time.LocalDateTime;
import excepciones.*;

public class Pedido {
    private LocalDateTime fecha;
    //private String tipoServicio;
    private String zona;
    private boolean mascotas;
    private boolean equipaje;
    private int cantidadPasajeros;
    private Cliente cliente;
    private int distancia;

    public Pedido(LocalDateTime fecha, String zona, boolean mascotas, boolean equipaje, int cantidadPasajeros, Cliente cliente, int distancia) {
        assert zona != null;
        assert cantidadPasajeros > 0;
        assert distancia > 0;
    	
    	this.fecha = fecha;
        this.zona = zona;
        this.mascotas = mascotas;
        this.equipaje = equipaje;
        this.cantidadPasajeros = cantidadPasajeros;
        this.cliente = cliente;
        this.distancia = distancia;
    }

    public String getZona() {
        return this.zona;
    }

    public boolean isMascotas() {
        return this.mascotas;
    }

    public boolean isEquipaje() {
        return this.equipaje;
    }

    public int getDistancia() {
		return distancia;
	}

	public int getCantidadPasajeros() {
        return this.cantidadPasajeros;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	/*public double ObtieneCosto()  {
        double ValorBase = 1000.0;
        double aux=1000.0;

        if(this.getZona().equalsIgnoreCase("Estandar")) {
            aux += ValorBase*0.1*this.getCantidadPasajeros();
            aux += ValorBase*0.1*this.getDistancia();
        }
        else if(this.getZona().equalsIgnoreCase("Sin asfaltar")) {
            aux += ValorBase*0.2*this.getCantidadPasajeros();
            aux += ValorBase*0.15*this.getDistancia();
        }
        else if(this.getZona().equalsIgnoreCase("Peligrosa")){
            aux += ValorBase*0.1*this.getCantidadPasajeros();
            aux += ValorBase*0.2*this.getDistancia();
        }
        else{
            throw new ZonaNoDefinidaException("La zona " + this.getZona() + " no esta definida.");
        }
        if(this.isMascotas()) {
            aux += ValorBase*0.1*this.getCantidadPasajeros();
            aux += ValorBase*0.2*this.getDistancia();
        }

        if(this.isEquipaje()) {
            aux += ValorBase*0.1*this.getCantidadPasajeros();
            aux += ValorBase*0.05*this.getDistancia();
        }
        return aux;
    }*/

}
