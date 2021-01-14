
package com.mycompany.modelo;

import java.io.Serializable;

public class Usuario extends Jugador implements Serializable {
   private String nombre;
    
   //CONSTRUCTOR
    public Usuario(String nombre, Tabla tabla) {
        super(tabla);
        this.nombre = nombre;
    }
    
    //GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    //TOSTRING
    @Override
    public String toString() {
        return "Nombre: "+nombre+super.toString();
    }
    
   
}