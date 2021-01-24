package com.mycompany.poo_grupo1_paralelo2;
import com.mycompany.modelo.Computadora;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.mycompany.modelo.Alineacion;
import com.mycompany.modelo.Juego;
import com.mycompany.modelo.Mazo;
import com.mycompany.modelo.Reporte;
import com.mycompany.modelo.Tabla;
import com.mycompany.modelo.Usuario;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        juego.setInitialTime(System.currentTimeMillis());
        juego.crearGrid(leftVBox,gridP, gridP2, gridP3);
        juego.leerAlineacion(leftVBox, alineacion);
        
        
        MazoMove mostrar= new MazoMove(m,juego);
        mostrar.start();
        verificarAlineacion(juego, mostrar);
        
    }
    
    public  void verificarAlineacion(Juego juego, MazoMove mostrar){
        
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
                            juego.setHayGanador(true);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText("Resultado de la operacion");
                            alert.setContentText("Ganaste c:");
                            alert.showAndWait();
                            juego.setFinalTime(System.currentTimeMillis());//OBTENCION DE TIEMPO FINAL
                            juego.setDuracion((juego.getFinalTime()-juego.getInitialTime())/1000);
                         
                            Reporte report = new Reporte(juego);
                            report.crearReporte();
                            App.setRoot("primary");
                            mostrar.stop();
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
        Juego j;
        public MazoMove(Mazo m,Juego j){ 
            this.m = m;
            this.j = j;
        }
        @Override
        public void run() {
            moverMazo();
        }
        
        
        public void moverMazo(){
            boolean h=true; 
            String rutaImg;
            Random rand = new Random();
            if(!j.getHayGanador()){
                for(int i=0;i<m.getMazo().size()&& h;i++){//For para ir cambiando las rutas de las imagenes a mostrar en pantalla
                    int num = rand.nextInt(54);
                    if (!(m.getC_sacadas().contains(m.getMazo().get(num)))){
                        try{

                            rutaImg="files/Imagenes/"+m.getMazo().get(num).getId()+".png";//Ruta
                            Image img= new Image(rutaImg,200,250,false,false);//Creacion de la imagen a mostrar en la secuencia en pantalla
                            imgMazo.setImage(img);
                            m.getC_sacadas().add(m.getMazo().get(num));

                            if(!j.getComputadoras().isEmpty() && !j.getHayGanador()){
                                for (int n=0; n<j.getComputadoras().size(); n++){
                                    if (j.getComputadoras().get(n).getTabla().getCartas().contains(m.getMazo().get(num))){
                                        j.getComputadoras().get(n).getTabla().verificarCarta(m.getMazo().get(num));

                                        jugabilidadOponentes juop =new jugabilidadOponentes(j.getComputadoras().get(n), m, j.getAlineacion(),j);
                                        juop.setDaemon(true);
                                        juop.start();
                                        
                                        if(j.getHayGanador()){
                                            juop.stop();
                                        }
                                    }  
                                }
                            }
                            Thread.sleep(3000);//Tiempo de espera entre cada imagen de 3 segundos
                        }catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }else{i--;}
                }
            }
        }
    }
    private class jugabilidadOponentes extends Thread{
        Computadora computadora;
        Mazo m;
        Alineacion a;
        boolean hayGanador;
        Juego juego;

        public jugabilidadOponentes(Computadora computadora, Mazo m, Alineacion a, Juego juego) {
            this.computadora = computadora;
            this.m = m;
            this.a = a;
            this.hayGanador = juego.getHayGanador();
            this.juego = juego;
        }

        @Override
        public void run(){
            loteriaCompu();
        }
        
        public void loteriaCompu(){
            if(!juego.getHayGanador()){
                boolean q=true;
                ArrayList<Integer> n = new ArrayList<Integer>();
                Tabla t = computadora.getTabla();
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
                                Thread.sleep(5000);
                                App.setRoot("primary");
                                juego.setHayGanador(true);
                                q=false;
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } 
                }
            }
        } 
    }
}