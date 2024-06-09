package vista;

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
  public static final String ESTANDAR = "Estándar";
  public static final String SINASFALTAR = "Sin asfaltar";
  public static final String PICANTE = "Picante";
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

}