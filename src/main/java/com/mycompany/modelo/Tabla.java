package com.mycompany.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Tabla implements Serializable {
    private boolean loteria;
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> c_marcadas;

    public Tabla(Mazo m) {
        cartas = new ArrayList<Carta>();
        c_marcadas = new ArrayList<Carta>();
        Random rand = new Random();
        for (int i=0; i<16; i++){
            int num = rand.nextInt(54);
            if (!(cartas.contains(m.getMazo().get(num)))){
            Carta carta = m.getMazo().get(num);
            cartas.add(carta);
        }else{i--;}
       }
    }
    
    

    public boolean isLoteria() {
        return loteria;
    }

    public void setLoteria(boolean loteria) {
        this.loteria = loteria;
    }

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
        return "Tabla{" + "loteria=" + loteria + ", cartas=" + cartas + ", c_marcadas=" + c_marcadas + '}';
    }
    
    
}
