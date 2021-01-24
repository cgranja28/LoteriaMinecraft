package com.mycompany.modelo;
import com.mycompany.poo_grupo1_paralelo2.App;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.lang.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
public class Juego implements Serializable {
    
    private int id_juego;
    private Usuario usuario;
    private Mazo mazo;
   //La variable alineacion esta con mayusculas en el diagrama (Cambiar)
    private Alineacion alineacion;
    private Configuracion configuracion;
    private long initialTime;
    private long finalTime;
    private Date fecha;
    private ArrayList<Computadora> computadoras;
    private boolean hayGanador;
    private long duracion;
    //CONSTRUCTOR
    public Juego(Usuario jugador, Mazo mazo) {
        usuario = jugador;
        configuracion = leerConfiguracion();
        this.alineacion = configuracion.getAlineacion();
        this.mazo = mazo;
        mazo.crearMazo();
        this.computadoras = new ArrayList<Computadora>();
        if (configuracion.getNumero_de_oponentes()!=0) {
            for(int j = 0; j <configuracion.getNumero_de_oponentes() ; j++){
                Computadora c=new Computadora(new Tabla(mazo));
                this.computadoras.add(c);
            }  
        }
        
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
        public long getDuracion() {
            return duracion;
        }
        /////////////////////////////////////////////////////
        public void setDuracion(long duracion) {
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
        /////////////////////////////////////////////////////
        public ArrayList<Computadora> getComputadoras() {
            return computadoras;
        }
        /////////////////////////////////////////////////////
        public void setComputadoras(ArrayList<Computadora> computadoras) {
            this.computadoras = computadoras;
        }
        /////////////////////////////////////////////////////
        public boolean getHayGanador() {
            return hayGanador;
        }
        /////////////////////////////////////////////////////
        public void setHayGanador(boolean hayGanador) {
            this.hayGanador = hayGanador;
        }
        /////////////////////////////////////////////////////
        public long getInitialTime() {
            return initialTime;
        }
        /////////////////////////////////////////////////////
        public void setInitialTime(long initialTime) {
            this.initialTime = initialTime;
        }
        /////////////////////////////////////////////////////
        public long getFinalTime() {
            return finalTime;
        }
        /////////////////////////////////////////////////////
        public void setFinalTime(long finalTime) {
            this.finalTime = finalTime;
        }
        
        
        
        
        public void crearGrid(VBox vbox,GridPane gridP,GridPane gridP1,GridPane gridP2) {
            boolean visible = configuracion.getVisibilidad();
            if(configuracion.getNumero_de_oponentes()==0){
            vbox.getChildren().remove(gridP1);
            vbox.getChildren().remove(gridP2);
            }
            else if(configuracion.getNumero_de_oponentes()==1){
                gridP1.setMaxSize(160, 160);
                vbox.getChildren().remove(2);
            }
            
            ArrayList<GridPane> gp= new ArrayList<GridPane>();
            gp.add(gridP1);
            gp.add(gridP2);
            //Tabla t = usuario.getTabla();
            Tabla  t=null;
            t=usuario.getTabla();
            crearGridPantalla(t,gridP,true,100,120,visible);
             for(int n=0; n<computadoras.size(); n++){
                t=computadoras.get(n).getTabla();
                crearGridPantalla(t,gp.get(n),false,30,40,visible);
            }
        }
        
        public void crearGridPantalla(Tabla t,GridPane gridP,boolean jugador,int x,int y, boolean visibility){
            Image image;
            String fileName = "";
            for (int i=0;i<t.getCartas().size();i++){
                StackPane sp = new StackPane();// Creacion stackpane
                int fila = i/4;
                int columna = i%4;
                Carta c = t.getCartas().get(i);
                
                // Creacion de rutas de las imagenes d elas cartas
                if(!jugador && !visibility){
                    fileName ="files/Imagenes/back.png";
                }else if(!jugador && visibility){
                    fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";
                }else {
                    fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";
                }
                
                image = new Image(fileName, x, y, false, false);
                ImageView imagen = new ImageView(image);
                
                sp.getChildren().add(imagen);// Se añade la imagen al Stackpane
                
                imagen.setId(String.valueOf(c.getId()));
                gridP.add(sp, columna, fila);// Se añade el stackpane al GridPane
                
                if(jugador){
                    imagen.setOnMouseClicked(e->{
                    boolean match=false;
                    boolean stop = true; 
                    for(int j=0; j<mazo.getC_sacadas().size() && stop; j++){
                    
                        if(String.valueOf(mazo.getC_sacadas().get(j).getId()).equals(imagen.getId())){
                            t.verificarCarta(mazo.getC_sacadas().get(j));
                            stop = false;
                            match = true;
                        }   
                    }
                        if(match){
                        sp.getChildren().add(new ImageView(new Image("images/esmeralda.png", 100, 120, false, false)));
                        }else{

                            /*try {

                                ImageView checked=new ImageView(new Image("files/Imagenes/X.png", 100, 120, false, false));
                                sp.getChildren().add(checked);
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }*/
                        }
                        });
                    }
                }
        }
        
        /////////////////////////////////////////////////////
        public Configuracion leerConfiguracion(){
           ObjectInputStream in;
        Configuracion confi=null;
        try {
            in = new ObjectInputStream(new FileInputStream(App.pathSettigns));
            confi = (Configuracion) in.readObject();//hay que hacer casting
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException:" + ex.getMessage());
        }

        return confi;
        }
        
        public void leerAlineacion(VBox leftVBox, ImageView imagen){
            int ali= alineacion.getId();
            String pathaligment ="images/"+ali+".png";
            imagen = new ImageView(pathaligment);
            imagen.setFitHeight(200);
            imagen.setFitWidth(150);
            leftVBox.getChildren().set(0, imagen);

        }
        
        //INICIAR JUEGO 
        public void iniciarJuego() {
            
        }
        /////////////////////////////////////////////////////
        //LOTERIA
        public void loteria(){
        }
        
        
    @Override
    public String toString() {
        return "Juego{" + "id_juego=" + id_juego + ", usuario=" + usuario + ", mazo=" + mazo + ", alineacion=" + alineacion + ", configuracion=" + configuracion + ", fecha=" + fecha + '}';
    }
     
     public class Xfile extends Thread{
        StackPane sp;
        ImageView imagen;
        public Xfile(StackPane sp,ImageView imagen){
            this.sp=sp;
            this.imagen=imagen;
        }
        @Override
        @FXML
        public void run() {
             
        boolean match=false;
        boolean stop = true; 
            for(int j=0; j<mazo.getC_sacadas().size() && stop; j++){

                if(String.valueOf(mazo.getC_sacadas().get(j).getId()).equals(imagen.getId())){
                    
                    
                    stop = false;
                    match = true;
                }   
            }
            if(match){
            sp.getChildren().add(new ImageView(new Image("images/esmeralda.png", 100, 120, false, false)));
            }else{
            sp.getChildren().add(new ImageView(new Image("files/Imagenes/X.png", 100, 120, false, false)));
            }

            }
        }
}

