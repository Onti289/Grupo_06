package vista;

import controladores.*;

public interface IVista
{
  public static final String SI = "Si";
  public static final String NO = "No";
  public static final String NUEVASIM = "Nueva simulación";
  public static final String SIMALEAT = "Cargar simulación aleatoria";

  public void dispose();
  public void setControlador(Controlador c);
  public void arranca();
  public void noHumano();
  public void hayHumano();
  public boolean isActive();

}