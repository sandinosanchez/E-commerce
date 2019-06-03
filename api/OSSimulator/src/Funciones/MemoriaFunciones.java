package Funciones;

import Entidades.Memoria;
import Entidades.Particiones;
import Entidades.Proceso;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MemoriaFunciones {

    private Memoria memoria;

    private ParticionesFunciones particionesFunciones;


    public Memoria nuevaMemoria(int tMemoria ){

        int tParticiones = 0;

        for (Map.Entry<Integer,Particiones> entry : memoria.getParticionesHashMap().entrySet()) {
            tParticiones = tParticiones + p.getTparticion();
        }

        boolean flag = true;
        if (tParticiones >= tMemoria) flag = false;

        if((tMemoria <= (memoria.gettMemoria())) & flag) return new Memoria(tMemoria, particiones);
        return null;
    }

    public void firstFit(Memoria memoria, Proceso proceso){

        for (Particiones p: memoria.getParticionesList()) {
            if (!p.isOcupada()){
                p.setProceso(proceso);
                break;
            }
        }
    }

    public void bestFit(Proceso proceso){

        Particiones part;
        List<Particiones> bestfitList = new ArrayList<>();
        for (Particiones p: memoria.getParticionesList()){
            if ((!p.isOcupada()) & (proceso.gettProceso() <= p.getTparticion())){
                if (particionesFunciones.tamaLibre(p) > 0)

                    bestfitList.add(p);
            }
            for (Particiones pa: bestfitList){

            }
        }
    }
}
