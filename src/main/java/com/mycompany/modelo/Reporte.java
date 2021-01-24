package com.mycompany.modelo;
import com.mycompany.poo_grupo1_paralelo2.App;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * 
 * @author Grupo1
 */
public class Reporte implements Serializable {
    LocalDate localDate ;
    private Juego juego;
    private String date;
    private String duration;
    private String name;
    private String opponents;
    private String alignment;
    /**
     * 
     * @param juego 
     * Recibe un juego para extraer los datos necesarios para mostrarlos en la ventana reporte
     */
    public Reporte(Juego juego) {
        this.localDate= LocalDate.now();
        this.juego = juego;
        this.date=localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.duration=String.valueOf(juego.getDuracion());
        this.name=juego.getUsuario().getNombre();
        this.opponents=String.valueOf(juego.getConfiguracion().getNumero_de_oponentes());
        this.alignment=juego.getAlineacion().getNombre();
    }

    
    
    
    
    public void crearReporte(){
        /**
         * fecha, duración, nombre del usuario, cantidad de oponentes, alineación
         * aqui serializar el arraylist de reporteJuego, crear archivo en la carpeta recursos
        */
        
        try {
            FileWriter writer = new FileWriter(App.pathReport,true);/*true significa que escribe al final del archivo*/
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
            "Date: "+date+" | "+
            "Duration: "+duration+" sec | "+
            "Username: "+name+" | "+
            "Opponents: "+opponents+" | "+
            "Alignment: "+alignment          
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    //GETTER AND SETTER

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpponents() {
        return opponents;
    }

    public void setOpponents(String opponents) {
        this.opponents = opponents;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
    
}
