package modelo;

import controladores.*;

public class Modelo {

    private static boolean hayHumano = false;
    private static boolean nuevaSim = false;

    public Modelo() {
        // TODO Auto-generated constructor stub
    }

    public boolean isHayHumano() {
        return hayHumano;
    }

    public void setHayHumano(boolean hayHumano) {
        this.hayHumano = hayHumano;
    }

    public boolean isNuevaSim() {
        return nuevaSim;
    }

    public void setNuevaSim(boolean nuevaSim) {
        this.nuevaSim = nuevaSim;
    }

}