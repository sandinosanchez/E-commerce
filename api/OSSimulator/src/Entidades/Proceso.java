package Entidades;

import java.util.List;

public class Proceso {

    private int idProceso;                   // id del proceso
    private List<Rafaga> rafaga;             // rafaga de CPU-E/S-CPU
    private int tRetorno;
    private int tEspera;
    private Particiones pRealcionada;        // particion de la memoria en la cual esta cargado el proceso
    private int tProceso;                    // tamaño del proceso
    private int tArrivo;                     // tiempo en el que el proceso llega a la cola de neuevo

    public Proceso(int idProceso, List<Rafaga> rafaga, int tRetorno, int tEspera, Particiones pRealcionada, int tProceso, int tArrivo) {
        this.idProceso = idProceso;
        this.rafaga = rafaga;
        this.tRetorno = tRetorno;
        this.tEspera = tEspera;
        this.pRealcionada = pRealcionada;
        this.tProceso = tProceso;
        this.tArrivo = tArrivo;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public List<Rafaga> getRafaga() {
        return rafaga;
    }

    public void setRafaga(List<Rafaga> rafaga) {
        this.rafaga = rafaga;
    }

    public int gettRetorno() {
        return tRetorno;
    }

    public void settRetorno(int tRetorno) {
        this.tRetorno = tRetorno;
    }

    public int gettEspera() {
        return tEspera;
    }

    public void settEspera(int tEspera) {
        this.tEspera = tEspera;
    }

    public Particiones getpRealcionada() {
        return pRealcionada;
    }

    public void setpRealcionada(Particiones pRealcionada) {
        this.pRealcionada = pRealcionada;
    }

    public int gettProceso() {
        return tProceso;
    }

    public void settProceso(int tProceso) {
        this.tProceso = tProceso;
    }

    public int gettArrivo() {
        return tArrivo;
    }

    public void settArrivo(int tArrivo) {
        this.tArrivo = tArrivo;
    }
}
