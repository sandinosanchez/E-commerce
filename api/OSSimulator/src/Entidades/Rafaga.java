package Entidades;

public class Rafaga {

    private int rafaga;
    private int tipoRafaga;

    public Rafaga(int rafaga, int tipoRafaga) {
        this.rafaga = rafaga;
        this.tipoRafaga = tipoRafaga;
    }

    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getTipoRafaga() {
        return tipoRafaga;
    }

    public void setTipoRafaga(int tipoRafaga) {
        this.tipoRafaga = tipoRafaga;
    }
}
