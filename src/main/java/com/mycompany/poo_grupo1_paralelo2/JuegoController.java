package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class JuegoController {
    @FXML GridPane gridP;
    @FXML BorderPane bP = new BorderPane();
    @FXML SplitPane sP = new SplitPane();
    @FXML Button boton = new Button();
    @FXML Label lbT;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void initialize() {
        lbT = new Label("LOTERIA");
        for (int i=0;i<15;i++){
            StackPane sp = new StackPane();
            int fila = i/3;
            int columna = i%3;
            Label lb = new Label("label"+fila+"-"+columna);
            sp.getChildren().add(lb);
            gridP.add(sp, columna, fila);
            
            lb.setOnMouseClicked(e->{
                   Label lbx = new Label("X");
                   sp.getChildren().add(lbx);
            });
        }
    }
    
}