
package com.mycompany.modelo;

import java.io.Serializable;

public abstract class Jugador implements Serializable {
    private boolean ganador;
    private Tabla tabla;
    
    //CONSTRUCTOR
    public Jugador(Tabla tabla){
        this.tabla=tabla;
        ganador=false;
    }
    
    //GETTERS AND SETTERS
    public boolean getGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }
    
    //TOSTRING
    @Override
    public String toString(){
        return "\nTabla: "+tabla+"\nGanador: "+ganador;
    }
    
}