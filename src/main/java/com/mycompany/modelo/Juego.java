package com.mycompany.modelo;
import java.io.Serializable;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
public class Juego implements Serializable {
    private int id_juego;
    private Usuario usuario;
    private Mazo mazo;
   //La variable alineacion esta con mayusculas en el diagrama (Cambiar)
    private Alineacion alineacion;
    private Configuracion configuracion;
    private double duracion;
    private Date fecha;
    
    //CONSTRUCTOR
    public Juego(Usuario jugador, Mazo mazo) {
        usuario = jugador;
        configuracion = new Configuracion(1,true);
        this.mazo = mazo;
        mazo.crearMazo();
    }
    
    //METODOS
        //GETTERS AND SETTERS 
        public int getId_juego() {
            return id_juego;
        }
        /////////////////////////////////////////////////////
        public void setId_juego(int id_juego) {
            this.id_juego = id_juego;
        }
        /////////////////////////////////////////////////////
        public Usuario getUsuario() {
            return usuario;
        }
        /////////////////////////////////////////////////////
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
        /////////////////////////////////////////////////////
        public Mazo getMazo() {
            return mazo;
        }
        /////////////////////////////////////////////////////
        public void setMazo(Mazo mazo) {
            this.mazo = mazo;
        }
        /////////////////////////////////////////////////////
        public Alineacion getAlineacion() {
            return alineacion;
        }
        /////////////////////////////////////////////////////
        public void setAlineacion(Alineacion alineacion) {
            this.alineacion = alineacion;
        }
        /////////////////////////////////////////////////////
        public Configuracion getConfiguracion() {
            return configuracion;
        }
        /////////////////////////////////////////////////////
        public void setConfiguracion(Configuracion configuracion) {
            this.configuracion = configuracion;
        }
        /////////////////////////////////////////////////////
        public double getDuracion() {
            return duracion;
        }
        /////////////////////////////////////////////////////
        public void setDuracion(double duracion) {
            this.duracion = duracion;
        }
        /////////////////////////////////////////////////////
        public Date getFecha() {
            return fecha;
        }
        /////////////////////////////////////////////////////
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
        
        public void crearGrid(GridPane gridP, boolean jugador) {
        Tabla t = usuario.getTabla();
        Image image;
        for (int i=0;i<t.getCartas().size();i++){
            StackPane sp = new StackPane();// Creacion stackpane
            int fila = i/4;
            int columna = i%4;
            Carta c = t.getCartas().get(i);
            String fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";// Creacion de rutas de las imagenes d elas cartas
            
            if (jugador){
                image = new Image(fileName, 100, 120, false, false);
            }else{
                image = new Image(fileName, 30, 40, false, false);
            }
            
            ImageView imagen = new ImageView(image);
            sp.getChildren().add(imagen);// Se añade la imagen al Stackpane
            gridP.add(sp, columna, fila);// Se añade el stackpane al GridPane
            sp.setOnMouseClicked(e->{
                String Xfile ="images/esmeralda.png";
                Image x = new Image(Xfile, 100, 120, false, false);
                sp.getChildren().add(new ImageView(x));
            });
        }
        }
        
        //INICIAR JUEGO 
        public void iniciarJuego() {
            
        }
        /////////////////////////////////////////////////////
        //LOTERIA
        public void loteria(){
        }
        
}
