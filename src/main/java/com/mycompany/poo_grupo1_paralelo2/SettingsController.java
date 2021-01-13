/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author Elix
 */
public class SettingsController implements Initializable {


    @FXML
    private Button bDone2;
    @FXML
    private Button bExit2;
    @FXML
    private ComboBox<?> CBxOpponents;
    @FXML
    private CheckBox ChVisible;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void switchToJuego() throws IOException {
        App.setRoot("Juego");
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
}
