package Funciones;

import Entidades.Particiones;

public class ParticionesFunciones {

    public int tamaLibre(Particiones particion){
        if (!particion.isOcupada()){
            return (particion.getTparticion() - particion.getProceso().gettProceso());
        }
        return 9000;
    }
}
