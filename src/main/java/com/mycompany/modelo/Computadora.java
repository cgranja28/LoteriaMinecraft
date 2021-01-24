package com.mycompany.modelo;

import java.io.Serializable;
/**
 * 
 * @author User
 */
public class Computadora extends Jugador implements Serializable {
    
    //CONSTRUCTOR
    /**
     * 
     * @param tabla
     * tabla para crear los oponentes del jugador
     */
    public Computadora(Tabla tabla) {
        super(tabla);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return super.toString();
    }
    
}