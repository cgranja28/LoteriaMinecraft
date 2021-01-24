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
        /**
         * Creacion de los objetos para ejecutar el juego
         */
        Mazo m = new Mazo();
        Tabla t = new Tabla(m);
        Usuario usuario = new Usuario(user, t);
        Juego juego = new Juego(usuario, m);
        /**
         * Contador de tiempo de duracion del juego al ejecutarlo
         */
        juego.setInitialTime(System.currentTimeMillis());
        /**
         * Creacion de grid de los jugadores
         */
        juego.crearGrid(leftVBox,gridP, gridP2, gridP3);
        juego.leerAlineacion(leftVBox, alineacion);
        /**
         * Llamada al hilo que controlorará el movimiento del mazo 
         */
        MazoMove mostrar= new MazoMove(m,juego);
        mostrar.start();
        /**
         * Verificacion del loteria
         */
        verificarAlineacion(juego, mostrar);
        
    }
    /**
     * 
     * @param juego
     * @param mostrar 
     * Metodo encargado de validar loteria del jugador y computadora
     */
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
                n.add(ind);/*Extrae los indices de las cartas marcadas del tblero del usuario*/
                }catch(NullPointerException ex){
                System.out.println(ex.getMessage());
                }
            }
            /**
             * Comporbacion de todas las combinaciones posibles de la alineacion del juego
             */
            for (int i=0; i<a.getCombinaciones().size()&& q;i++){
                
                for (int j=0; j<a.getCombinaciones().get(i).size()&&q; j++){
    
                    if(n.containsAll(a.getCombinaciones().get(i))){
                        try {/**
                         * En caso de ser ganador aparece alerta al jugador
                         */
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
                            App.setRoot("primary");/*Se lo redirige a la ventana principal*/
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
    
    /**
     * Hilo para movimiento del mazo
     */
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
        
        /**
         * Metodo a usar
         */
        public void moverMazo(){
            boolean h=true; 
            String rutaImg;
            Random rand = new Random();
            if(!j.getHayGanador()){
                for(int i=0;i<m.getMazo().size()&& h;i++){/*For para ir cambiando las rutas de las imagenes a mostrar en pantalla*/
                    int num = rand.nextInt(54);
                    if (!(m.getC_sacadas().contains(m.getMazo().get(num)))){/*Validacion de cartas sacadas randonmente en el mazo*/
                        try{
                            rutaImg="files/Imagenes/"+m.getMazo().get(num).getId()+".png";//Ruta
                            Image img= new Image(rutaImg,200,250,false,false);//Creacion de la imagen a mostrar en la secuencia en pantalla
                            imgMazo.setImage(img);
                            m.getC_sacadas().add(m.getMazo().get(num));
                            
                            if(!j.getComputadoras().isEmpty() && !j.getHayGanador()){/*Validacion de loteria de los oponentes*/
                                for (int n=0; n<j.getComputadoras().size(); n++){
                                    if (j.getComputadoras().get(n).getTabla().getCartas().contains(m.getMazo().get(num))){
                                        j.getComputadoras().get(n).getTabla().verificarCarta(m.getMazo().get(num));
                                        /**
                                         * Llamada al hilo que controlará la verificacion de loteria de los oponentes
                                         */
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
                    }else{i--;}/**
                     * En caso de que el random repita el numero no se perderá iteraciones puesto que se descontará uno en caso de 
                     * darse el caso
                     */
                }     
            }
        }
    }
    /**
     * Hilo de jubailidad de oponentes
     */
    private class jugabilidadOponentes extends Thread{
        Computadora computadora;
        Mazo m;
        Alineacion a;
        boolean hayGanador;
        Juego juego;
        /**
         * 
         * @param computadora
         * @param m
         * @param a
         * @param juego 
         * Atributos para verficar y controlar que las cartas del computador se marquen y en caso de ganar
         * se le de la loteria
         */
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
        /**
         * Metodo loteriaCompu
         */
        public void loteriaCompu(){
            if(!juego.getHayGanador()){
                boolean q=true;
                ArrayList<Integer> n = new ArrayList<Integer>();
                Tabla t = computadora.getTabla();
                for (int k=0; k<t.getC_marcadas().size() && q;k++){
                    try{
                    int ind = t.getCartas().indexOf(t.getC_marcadas().get(k));
                    n.add(ind);/**
                     * Extrae indices de la tabla de las cartas marcadas para que gane el computador
                     */
                    }catch(NullPointerException ex){
                    System.out.println(ex.getMessage());
                    }
                }
                    /**
                     * Verificacion de todas las combinaciones posibles de la alineacion del juego
                     */
                for (int i=0; i<a.getCombinaciones().size()&& q;i++){

                    for (int j=0; j<a.getCombinaciones().get(i).size()&&q; j++){

                        if(n.containsAll(a.getCombinaciones().get(i))){
                            try {/**
                             * En caso de completar alguna alineacion se espera 5 segundos
                             */
                                Thread.sleep(5000);
                                App.setRoot("primary");
                                juego.setHayGanador(true);/**
                                 * Si pasa este tiempo se redirige al usuario automaticamente a la pagina principal
                                 */
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