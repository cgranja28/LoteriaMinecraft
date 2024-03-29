
package com.mycompany.modelo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Grupo1
 */
public class Mazo implements Serializable {
    private ArrayList<Carta> mazo;
    private ArrayList<Carta> c_sacadas;
    /**
     * Constructor
     */
    public Mazo() {
        mazo = crearMazo();
        c_sacadas = new ArrayList<Carta>();
        
    }
    /**
     * 
     * @return
     * retorna el mazo creado por los datos extraidos del csv de cartas al crear cartas e introdcurilas a un ArrayList
     */
    public ArrayList<Carta> crearMazo() {
        ArrayList<Carta> cartss = new ArrayList<Carta>();
        try (FileReader reader = new FileReader("src/main/resources/files/cartasloteria.csv")){
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] ln = line.split(",");/**
                 * Crea cartas antes de introducirlas en el arrayList
                 */
                Carta carta = new Carta(Integer.parseInt(ln[0]),ln[1]);
                cartss.add(carta);
            }
            
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("pos si es aqui gg");
        }
        return cartss;
    }
    /*Getters and Setters*/
    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Carta> getC_sacadas() {
        return c_sacadas;
    }

    public void setC_sacadas(ArrayList<Carta> c_sacadas) {
        this.c_sacadas = c_sacadas;
    }
}
