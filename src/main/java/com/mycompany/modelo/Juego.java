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
    private double duracion;
    private Date fecha;
    private ArrayList<Computadora> computadoras;
    
    //CONSTRUCTOR
    public Juego(Usuario jugador, Mazo mazo) {
        usuario = jugador;
        configuracion = leerConfiguracion();
        this.mazo = mazo;
        mazo.crearMazo();
        this.computadoras = new ArrayList<Computadora>();
        if (configuracion.getNumero_de_oponentes()!=0) {
            for(int j = 0; j <= configuracion.getNumero_de_oponentes() ; j++){
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

        public ArrayList<Computadora> getComputadoras() {
            return computadoras;
        }

        public void setComputadoras(ArrayList<Computadora> computadoras) {
            this.computadoras = computadoras;
        }
        
        
        /////////////////////////////////////////////////////
        public void crearGridComputadora(Juego juego, VBox vbox, GridPane gridP2, GridPane gridP3, int num_comp) {
            if(num_comp==0){
            vbox.getChildren().remove(gridP2);
            vbox.getChildren().remove(gridP3);
            }
            else if(num_comp-1==1){
                juego.crearGridUsuario(gridP2, false, 30, 40);
                gridP2.setMaxSize(160, 160);
                vbox.getChildren().remove(2);
            }
            else if(num_comp-1==2){
                juego.crearGridUsuario(gridP2, false, 30, 40);
                juego.crearGridUsuario(gridP3, false, 30, 40);
                gridP2.setMaxSize(200, 200);
                gridP3.setMaxSize(200, 200);
            }
            
        }
         
        public void crearGridUsuario(GridPane gridP, boolean jugador, int x,int y) {
            
            //Tabla t = usuario.getTabla();
            Tabla  t=usuario.getTabla();
            /*if(jugador){
                t=usuario.getTabla();
            }else{
                for(int n=0; n<computadoras.size(); n++){
                  t=computadoras.get(n).getTabla();
                } 
            }*/
            Image image;
            for (int i=0;i<t.getCartas().size();i++){
                StackPane sp = new StackPane();// Creacion stackpane
                int fila = i/4;
                int columna = i%4;
                Carta c = t.getCartas().get(i);
                String fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";// Creacion de rutas de las imagenes d elas cartas
                image = new Image(fileName, x, y, false, false);
                /*if (jugador){
                    image = new Image(fileName, 100, 120, false, false);
                }else{
                    image = new Image(fileName, 30, 40, false, false);
                }*/

                ImageView imagen = new ImageView(image);
                sp.getChildren().add(imagen);// Se añade la imagen al Stackpane
                gridP.add(sp, columna, fila);// Se añade el stackpane al GridPane
                if (jugador){
                    sp.setOnMouseClicked(e->{
                        String Xfile ="images/esmeralda.png";
                        Image X = new Image(Xfile, x, y, false, false);
                        sp.getChildren().add(new ImageView(X));
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
            Configuracion settings=null;
		try {
			InputStream file = new FileInputStream(App.pathSettigns);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			
			 settings = (Configuracion)input.readObject();
                         
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
            int ali= settings.getAlineacion().getId();
            String pathaligment ="images/"+ali+".png";
            imagen = new ImageView(pathaligment);
            imagen.setFitHeight(200);
            imagen.setFitWidth(150);
            //leftVBox.getChildren().add(imagen);
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
        return "Juego{" + "id_juego=" + id_juego + ", usuario=" + usuario + ", mazo=" + mazo + ", alineacion=" + alineacion + ", configuracion=" + configuracion + ", duracion=" + duracion + ", fecha=" + fecha + '}';
    }
        
        
}
