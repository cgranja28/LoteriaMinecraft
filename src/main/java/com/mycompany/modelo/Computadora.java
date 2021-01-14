package com.mycompany.modelo;

import java.io.Serializable;

public class Computadora extends Jugador implements Serializable {
    
    //CONSTRUCTOR
    public Computadora(Tabla tabla) {
        super(tabla);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return super.toString();
    }
    
}