package com.mycompany.poo_grupo1_paralelo2;

import com.mycompany.modelo.Carta;
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
        Mazo m = new Mazo();
        m.crearMazo();
        Tabla t = new Tabla(m);
        Tabla t2 = new Tabla(m);
           System.out.println(t2.getCartas().size());
        
        
        for (int i=0;i<t.getCartas().size();i++){
            StackPane sp = new StackPane();// Creacion stackpane
            StackPane sp2 = new StackPane();
            
            int fila = i/4;
            int columna = i%4;
            
            Carta c = t.getCartas().get(i);
            Carta c2 = t2.getCartas().get(i);
            
            String fileName ="files/Imagenes/"+String.valueOf(c.getId())+".png";// Creacion de rutas de las imagenes d elas cartas
            String fileName2 ="files/Imagenes/"+String.valueOf(c2.getId())+".png";
            
            Image image = new Image(fileName, 100, 120, false, false);
            ImageView imagen = new ImageView(image);
            
            Image image2 = new Image(fileName2, 30, 40, false, false);
            ImageView imagen2 = new ImageView(image2);
            
            sp.getChildren().add(imagen);// Se añade la imagen al Stackpane
            sp2.getChildren().add(imagen2);
            
            gridP.add(sp, columna, fila);// Se añade el stackpane al GridPane 
            gridP2.add(sp2, columna, fila);
            
            sp.setOnMouseClicked(e->{
                String Xfile ="images/esmeralda.png";
                Image x = new Image(Xfile, 100, 120, false, false);
                sp.getChildren().add(new ImageView(x));
            });

        }
    }
    
}