
package com.mycompany.modelo;

import java.io.Serializable;
/**
 * 
 * @author Grupo1
 */
public class Usuario extends Jugador implements Serializable {
   private String nombre;
    
   //CONSTRUCTOR
   /**
    * 
    * @param nombre
    * @param tabla 
    * nombre extraido del campo de texto llenado por el usuario
    * y tabla unica para el
    */
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