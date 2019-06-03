package Entidades;

public class Particiones {

    private int tParticion;
    private boolean ocupada = false;
    private Proceso proceso;


    public Particiones(int tam, boolean ocupada, Proceso proceso) {
        this.tParticion = tam;
        this.ocupada = ocupada;
        this.proceso = proceso;
    }

    public int getTparticion() {
        return tParticion;
    }

    public void settParticion(int tam) {
        this.tParticion = tam;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }


}
