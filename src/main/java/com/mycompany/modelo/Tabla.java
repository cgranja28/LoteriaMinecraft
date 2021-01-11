package com.mycompany.modelo;

import java.util.ArrayList;

public class Tabla {
    private boolean loteria;
    private ArrayList<Carta> cartas;
    private ArrayList<Boolean> c_marcadas;

    public Tabla(boolean loteria, ArrayList<Carta> cartas, ArrayList<Boolean> c_marcadas) {
        this.loteria = loteria;
        this.cartas = cartas;
        this.c_marcadas = c_marcadas;
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

    public ArrayList<Boolean> getC_marcadas() {
        return c_marcadas;
    }

    public void setC_marcadas(ArrayList<Boolean> c_marcadas) {
        this.c_marcadas = c_marcadas;
    }

    public void verificarCarta(Carta carta){
        
    }
    
    @Override
    public String toString() {
        return "Tabla{" + "loteria=" + loteria + ", cartas=" + cartas + ", c_marcadas=" + c_marcadas + '}';
    }
    
    
}
