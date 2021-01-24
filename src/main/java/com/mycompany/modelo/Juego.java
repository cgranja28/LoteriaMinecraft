package com.mycompany.modelo;
import com.mycompany.poo_grupo1_paralelo2.App;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
/**
 * 
 * @author Grupo1
 */
public class Juego implements Serializable {
    
    private Usuario usuario;
    private Mazo mazo;
   //La variable alineacion esta con mayusculas en el diagrama (Cambiar)
    private Alineacion alineacion;
    private Configuracion configuracion;
    private long initialTime;
    private long finalTime;
    private ArrayList<Computadora> computadoras;
    private boolean hayGanador;
    private long duracion;
    //CONSTRUCTOR
    /**
     * 
     * @param jugador
     * @param mazo
     * Atributos para crear el objeto juego.
     * Mazo contendrá las 54 cartas disponibles
     * 
     */
    public Juego(Usuario jugador, Mazo mazo) {
        usuario = jugador;
        configuracion = leerConfiguracion();
        this.alineacion = configuracion.getAlineacion();
        this.mazo = mazo;
        mazo.crearMazo();
        this.computadoras = new ArrayList<Computadora>();
        if (configuracion.getNumero_de_oponentes()!=0) {/**
         * Crea los oponentes necesarios elegidos en la ventana de configuracion antes de inciar el juego
         */
            for(int j = 0; j <configuracion.getNumero_de_oponentes() ; j++){
                Computadora c=new Computadora(new Tabla(mazo));
                this.computadoras.add(c);
            }  
        }
        
    }
    
    //METODOS
        //GETTERS AND SETTERS 

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
        
        
        /**
         * 
         * @param vbox
         * @param gridP
         * @param gridP1
         * @param gridP2 
         * 
         * GridPane 1,2 y 3 utilizados para introducir las cartas de los tableros de cada jugador
         * Vbox se ubicaran los grids de los oponentes
         */
        public void crearGrid(VBox vbox,GridPane gridP,GridPane gridP1,GridPane gridP2) {
            boolean visible = configuracion.getVisibilidad();
            if(configuracion.getNumero_de_oponentes()==0){/**
             * Si numero de oponentes es 0 se quitan de la ventana de juego los grids asignados a los oponentes
             */
            vbox.getChildren().remove(gridP1);
            vbox.getChildren().remove(gridP2);
            }
            else if(configuracion.getNumero_de_oponentes()==1){/**
             * Si es igual a 1 entonces se quita solamente un gridpane del oponente
             */
                gridP1.setMaxSize(160, 160);/**
                 * Se estable el tamaño del gridpane del oponente
                 */
                vbox.getChildren().remove(2);
            }
            
            ArrayList<GridPane> gp= new ArrayList<GridPane>();
            gp.add(gridP1);
            gp.add(gridP2);
            //Tabla t = usuario.getTabla();
            Tabla  t=null;
            t=usuario.getTabla();
            /**
             * Crea el gridpane del usuario
             */
            crearGridPantalla(t,gridP,true,100,120,visible);
            /**
             * Crea los gridpane de los oponentes segun el numero de oponentes asignados
             */
             for(int n=0; n<computadoras.size(); n++){
                t=computadoras.get(n).getTabla();
                crearGridPantalla(t,gp.get(n),false,30,40,visible);
            }
        }
        /**
         * 
         * @param t
         * @param gridP
         * @param jugador
         * @param x
         * @param y
         * @param visibility 
         * Se envia los parametros para crear el gridpane ya sea de usuario u oponentes segun datos receptados
         */
        public void crearGridPantalla(Tabla t,GridPane gridP,boolean jugador,int x,int y, boolean visibility){
            Image image;
            String fileName = "";
            for (int i=0;i<t.getCartas().size();i++){
                StackPane sp = new StackPane();/**
                 * Creacion de stackpane
                 */
                int fila = i/4;
                int columna = i%4;
                Carta c = t.getCartas().get(i);
                /**
                 * Creacion de rutas de las imagenes de las cartas
                 */
                if(!jugador && !visibility){
                    fileName ="files/Imagenes/back.png";
                }else if(!jugador && visibility){
                    fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";
                }else {
                    fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";
                }
                
                image = new Image(fileName, x, y, false, false);
                ImageView imagen = new ImageView(image);
                
                sp.getChildren().add(imagen);/* Se añade la imagen al Stackpane*/
                sp.setId(String.valueOf(c.getId()));
                imagen.setId(String.valueOf(c.getId()));
                gridP.add(sp, columna, fila);/* Se añade el stackpane al GridPane*/
                gridP.setId(String.valueOf(c.getId()));
                if(jugador){
                    /**
                     * Metodo EventHandler para marcar cartas seleccionadas en el tablero del juego por el jugador
                     */
                    imagen.setOnMouseClicked(e->{
                    boolean match=false;
                    boolean stop = true; 
                    for(int j=0; j<mazo.getC_sacadas().size() && stop; j++){
                        /*Valida que la carta seleccionada haya salido en el mazo*/
                        if(String.valueOf(mazo.getC_sacadas().get(j).getId()).equals(imagen.getId())){
                            t.verificarCarta(mazo.getC_sacadas().get(j));
                            stop = false;
                            match = true;
                        }   
                    }   /*Si encuentra la carta seleccionada la marca con una esmeralda*/
                        if(match){
                        sp.getChildren().add(new ImageView(new Image("images/esmeralda.png", 100, 120, false, false)));
                        }
                        });
                    }
            }
        }
        
        /////////////////////////////////////////////////////
        /*
        *Desearealiza el documento de settings necesario para extraer la configuracion seleccionada por el usuario
        */
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
        
        /**
         * 
         * @param leftVBox
         * @param imagen 
         * Crear el imageview necesario para mostrar la carta de alineacion seleccionada aleatoriamente en pantalla
         * al ejecutar el juego
         */
        public void leerAlineacion(VBox leftVBox, ImageView imagen){
            int ali= alineacion.getId();
            String pathaligment ="images/"+ali+".png";
            imagen = new ImageView(pathaligment);
            imagen.setFitHeight(200);
            imagen.setFitWidth(150);
            leftVBox.getChildren().set(0, imagen);

        }
        
        
    @Override
    public String toString() {
        return "Juego{" + "usuario=" + usuario + ", mazo=" + mazo + ", alineacion=" + alineacion + ", configuracion=" + configuracion + '}';
    }
     
}

