package com.mycompany.poo_grupo1_paralelo2;

import com.mycompany.modelo.Alineacion;
import com.mycompany.modelo.Carta;
import com.mycompany.modelo.Juego;
import com.mycompany.modelo.Mazo;
import com.mycompany.modelo.Tabla;
import com.mycompany.modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class JuegoController {
    @FXML GridPane gridP;
    @FXML GridPane gridP2;
    @FXML GridPane gridP3;
    @FXML BorderPane bP;
    @FXML Button boton;
    @FXML VBox leftVBox;
    @FXML ImageView alineacion;
    @FXML ImageView imgMazo;
    @FXML ImageView loteria;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void initialize() {
        String user="";
	try {
            FileReader reader = new FileReader(App.pathJuego);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            user=bufferedReader.readLine();
            
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }             
        Mazo m = new Mazo();
        
        Tabla t = new Tabla(m);
        Usuario usuario = new Usuario(user, t);
        Juego juego = new Juego(usuario, m);
        
        juego.crearGrid(leftVBox,gridP, gridP2, gridP3);
        juego.leerAlineacion(leftVBox, alineacion);
        verificarAlineacion(juego);
        
        MazoMove mostrar= new MazoMove(m);
        mostrar.start();
        
    }
    
    public  void verificarAlineacion(Juego juego){
        boolean h=false;
                loteria.setOnMouseClicked(e->{
                    boolean q=true;
                    Alineacion a=juego.getAlineacion();
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    Tabla t = juego.getUsuario().getTabla();
                    for (int k=0; k<t.getC_marcadas().size() && q;k++){
                        try{
                        int ind = t.getCartas().indexOf(t.getC_marcadas().get(k));
                        n.add(ind);
                        }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                        }
                    }
            
            for (int i=0; i<a.getCombinaciones().size()&& q;i++){
                
                for (int j=0; j<a.getCombinaciones().get(i).size()&&q; j++){
    
                    if(n.containsAll(a.getCombinaciones().get(i))){
                        try {
                            juego.getUsuario().setGanador(true);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText("Resultado de la operacion");
                            alert.setContentText("Ganaste c:");
                            alert.showAndWait();
                            App.setRoot("primary");
                            q=false;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    }
                
            }
           });
        }
        
        
        
    

    
    
    public class MazoMove extends Thread{
        Mazo m;
        public MazoMove(Mazo m){ 
            this.m = m;
        }
        @Override
        public void run() {

            String rutaImg;
            Random rand = new Random();
            for(int i=0;i<m.getMazo().size();i++){//For para ir cambiando las rutas de las imagenes a mostrar en pantalla
                int num = rand.nextInt(54);
                if (!(m.getC_sacadas().contains(m.getMazo().get(num)))){
                    try{

                        rutaImg="files/Imagenes/"+m.getMazo().get(num).getId()+".png";//Ruta
                        Image img= new Image(rutaImg,200,200,false,false);//Creacion de la imagen a mostrar en la secuencia en pantalla
                        imgMazo.setImage(img);
                        m.getC_sacadas().add(m.getMazo().get(num));

                        Thread.sleep(1000);//Tiempo de espera entre cada imagen de 3 segundos

                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }else{i--;}
            }
        }
    }
}