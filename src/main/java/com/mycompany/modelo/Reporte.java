
package com.mycompany.modelo;
import java.util.*;
import java.io.*;
import java.text.*;

public class Reporte implements Serializable {
    private ArrayList<Juego> juegos;
    private ArrayList<String> juegoReporte;
    //CONSTRUCTOR

    public Reporte(){
        this.juegos = new ArrayList<Juego>();
        this.juegoReporte = new ArrayList<String>();
    }
    
    public void crearReporte(){
        for(int i=0;i<juegos.size();i++){
        //fecha, duración, nombre del usuario, cantidad de oponentes, alineación
        //aqui serializar el arraylist de reporteJuego, crear archivo en la carpeta recursos
        Juego juego=juegos.get(i);
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
    }
    
    
    //GETTER AND SETTER
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public ArrayList<String> getJuegoReporte() {
        return juegoReporte;
    }

    public void setJuegoReporte(ArrayList<String> juegoReporte) {
        this.juegoReporte = juegoReporte;
    }
    
    
}
