package clases;

import java.time.LocalDateTime;

public interface IViaje {
	int getPax();
	int getKM();
	double getCosto();
	Chofer getChofer();
	LocalDateTime getFecha();
	void setEstado(String e);
	Cliente getCliente();
}
