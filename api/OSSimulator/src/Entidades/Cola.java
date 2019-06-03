package Entidades;

import java.util.LinkedList;

public class Cola {

    private int tipoCola;
    private LinkedList<Proceso> cola;

    public Cola(int tipoCola, LinkedList<Proceso> cola) {
        this.tipoCola = tipoCola;
        this.cola = cola;
    }

    public int getTipoCola() {
        return tipoCola;
    }

    public void setTipoCola(int tipoCola) {
        this.tipoCola = tipoCola;
    }

    public LinkedList<Proceso> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Proceso> cola) {
        this.cola = cola;
    }
}
