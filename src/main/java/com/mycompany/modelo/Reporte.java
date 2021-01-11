
package com.mycompany.modelo;
import java.util.*;
import java.io.*;
import java.text.*;

public class Reporte {
    private Juego juego;
    private ArrayList<String> juegoReporte;
    //CONSTRUCTOR
    public Reporte(Juego juego){
        //fecha, duración, nombre del usuario, cantidad de oponentes, alineación
        //aqui serializar el arraylist de reporteJuego, crear archivo en la carpeta recursos
        FileOutputStream fout = null;
        juegoReporte=new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        juegoReporte.add(dateFormat.format(juego.getFecha()));
        juegoReporte.add(String.valueOf(juego.getDuracion()));
        juegoReporte.add(juego.getUsuario().getNombre());
        juegoReporte.add(String.valueOf(juego.getConfiguracion().getNumero_de_oponentes()));
        juegoReporte.add(String.valueOf(juego.getAlineacion()));
        try {//Creacion de archivo serializado de reportes
            fout = new FileOutputStream("files/reporte.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(juegoReporte);//Escritura del reporte en el archivo
            out.flush();
            out.close();
            System.out.println("\nReporte Correctamente Serializado");
        } catch (IOException ex) {//Validacion de serializacion
            System.out.println("IOException:" + ex.getMessage());
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }  
  
    
    //GETTER AND SETTER
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
}
