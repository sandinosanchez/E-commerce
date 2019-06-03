package Entidades;

import java.util.HashMap;

public class Memoria {

    private int tMemoria;
    private HashMap<Integer,Particiones> particionesHashMap;
    private HashMap<Integer,PCB> pcbHashMap;

    public Memoria(int tMemoria, HashMap<Integer,Particiones> particionesHashMap) {
        this.tMemoria = tMemoria;
        this.particionesHashMap = particionesHashMap;
    }

    public int gettMemoria() {
        return tMemoria;
    }

    public void settMemoria(int tMemoria) {
        this.tMemoria = tMemoria;
    }

    public HashMap<Integer,Particiones> getParticionesHashMap() {
        return particionesHashMap;
    }

    public void setParticionesHashMap(HashMap<Integer,Particiones> particionesHashMap) {
        this.particionesHashMap = particionesHashMap;
    }

    public HashMap<Integer,PCB> getPcbList() {
        return pcbHashMap;
    }

    public void setPcbHashMap(HashMap<Integer,PCB> pcbHashMap) {
        this.pcbHashMap = pcbHashMap;
    }
}
