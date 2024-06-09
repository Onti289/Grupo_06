package vista;

import controladores.*;

public interface IVista
{
  public static final String SI = "Si";
  public static final String NO = "No";
  public static final String NUEVASIM = "Nueva simulación";
  public static final String SIMALEAT = "Cargar simulación aleatoria";
  public static final String INICIASIM = "Iniciar simulación";
  public static final String CREARUSUARIO = "Crear";
  public static final String INICIARSESION = "Ingresar";


  public void dispose();
  public void setControlador(Controlador c);
  public void arranca();
  public void noHumano();
  public void hayHumano();
  public boolean isActive();
  public void setVisible(boolean b);
  public boolean isVisible();

}