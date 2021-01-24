package com.mycompany.modelo;

import java.io.Serializable;
/**
 * 
 * @author Grupo1
 */
public class Carta implements Serializable {
    private int id;
    private String nombre;
/**
 * 
 * @param id
 * @param nombre
 * Atributos para la creacion de cartas
 */
    public Carta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carta{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
