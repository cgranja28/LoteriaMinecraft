
package com.mycompany.modelo;

import java.io.Serializable;
/**
 * 
 * @author Grupo1
 */
public abstract class Jugador implements Serializable {
    private boolean ganador;
    private Tabla tabla;
    
    //CONSTRUCTOR
    /**
     * 
     * @param tabla
     * tabla linkeada al jugador creado
     */
    public Jugador(Tabla tabla){
        this.tabla=tabla;
        this.ganador=false;
    }
    
    //GETTERS AND SETTERS
    public boolean getGanador() {
        return this.ganador;
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