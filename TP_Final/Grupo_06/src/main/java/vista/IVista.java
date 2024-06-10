package vista;

import java.awt.event.WindowAdapter;

import controladores.*;

public interface IVista
{
  public static final String SI = "Si";
  public static final String NO = "No";
  public static final String NUEVASIM = "Nueva simulación";
  public static final String CARGAULT = "Cargar última simulación";
  public static final String INICIASIM = "Iniciar simulación";
  public static final String CREARUSUARIO = "Crear";
  public static final String INICIARSESION = "Ingresar";
  public static final String ESTANDAR = "Estandar";
  public static final String SINASFALTAR = "Calle sin asfaltar";
  public static final String PELIGROSA = "Zona peligrosa";
  public static final String ACEPTAR = "Aceptar";
  public static final String PAGAR = "Pagar";


  public void dispose();
  public void setControlador(Controlador c);
  public void arranca();
  public void noHumano();
  public void hayHumano();
  public boolean isActive();
  public void setVisible(boolean b);
  public boolean isVisible();
  public int getCantPax();
  public String getZona();
  public boolean isBaul();
  public boolean isMascota();
  public String getNombreReal();  
  public String getNuevoNomUsua();
  public String getNuevaContr();  
  public String getNomUsua();
  public String getContr();
public void setTextMsjInicSes(String string);
public void setTextMsjCrea(String string);
public void borraRegistrarse();
public void addWindowListener(WindowAdapter windowAdapter);
public int getVar_CantPermanentes();
public int getVar_CantMotos();
public int getVar_CantAutos();
public int getVar_CantCombis();
public int getVar_CantViajesXCliente();
public int getVar_CantClientes();
public int getVar_CantViajesXChofer();
public int getVar_CantTemporarios();
public int getVar_CantContratados();


}