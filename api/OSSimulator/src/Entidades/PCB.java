package Entidades;

public class PCB {

    private int idProceso;          // id del proceso
    private int tipoCola;           // en que cola estaba antes del cambio de contexto
    private int puntRafaga;         // puntero que indica en que rafaga estaba antes del cambio de conexto


    public PCB(int idProceso, int tipoCola, int puntRafaga) {
        this.idProceso = idProceso;
        this.tipoCola = tipoCola;
        this.puntRafaga = puntRafaga;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public int getTipoCola() {
        return tipoCola;
    }

    public void setTipoCola(int tipoCola) {
        this.tipoCola = tipoCola;
    }

    public int getPuntRafaga() {
        return puntRafaga;
    }

    public void setPuntRafaga(int puntRafaga) {
        this.puntRafaga = puntRafaga;
    }

}
