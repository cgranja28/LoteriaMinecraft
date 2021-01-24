package com.mycompany.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author Grupo1
 */
public class Tabla implements Serializable {
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> c_marcadas;
/**
 * 
 * @param m 
 * Crear tabla con cartas aleatorias sacadas del mazo enviado
 */
    public Tabla(Mazo m) {
        cartas = new ArrayList<Carta>();
        c_marcadas = new ArrayList<Carta>();
        Random rand = new Random();
        for (int i=0; i<16; i++){/**
         * El tablero constará de 16 cartas
         */
            int num = rand.nextInt(54);
            if (!(cartas.contains(m.getMazo().get(num)))){
            Carta carta = m.getMazo().get(num);
            cartas.add(carta);
        }else{i--;}/**
         * Validacion de que el random se ejecute 16 veces si se repite algun numero
         */
       }
    }
    
    /*Getters and Setters*/

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Carta> getC_marcadas() {
        return c_marcadas;
    }

    public void setC_marcadas(ArrayList<Carta> c_marcadas) {
        this.c_marcadas = c_marcadas;
    }

    public void verificarCarta(Carta carta){
        c_marcadas.add(carta);
    }
    
    @Override
    public String toString() {
        return "Tabla{" +  "cartas=" + cartas + ", c_marcadas=" + c_marcadas + '}';
    }
    
    
}
