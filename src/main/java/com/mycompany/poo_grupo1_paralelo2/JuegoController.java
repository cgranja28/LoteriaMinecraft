package com.mycompany.poo_grupo1_paralelo2;

import com.mycompany.modelo.Carta;
import com.mycompany.modelo.Juego;
import com.mycompany.modelo.Mazo;
import com.mycompany.modelo.Tabla;
import com.mycompany.modelo.Usuario;
import java.io.*;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
    @FXML BorderPane bP;
    @FXML Button boton;
    @FXML VBox leftVBox;
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
        
        juego.crearGrid(gridP, true);
        juego.leerAlineacion(leftVBox);
        juego.crearGrid(gridP2, false);
        
        
        
    }
    
}