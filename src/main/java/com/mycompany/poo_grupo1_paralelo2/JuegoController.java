package com.mycompany.poo_grupo1_paralelo2;

import com.mycompany.modelo.Carta;
import com.mycompany.modelo.Juego;
import com.mycompany.modelo.Mazo;
import com.mycompany.modelo.Tabla;
import com.mycompany.modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.layout.StackPane;

public class JuegoController {
    @FXML GridPane gridP;
    @FXML GridPane gridP2;
    @FXML BorderPane bP;
    @FXML Button boton;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void initialize() {
        /*juego.crearGrid(gridP, true);
        juego.crearGrid(gridP2, false);*/
        
    }
    
}