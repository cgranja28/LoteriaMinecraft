/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_grupo1_paralelo2;
import com.mycompany.modelo.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class SettingsController implements Initializable {

    
    @FXML
    private Button bDone2;
    @FXML
    private Button bExit2;
    @FXML
    private ComboBox<String>  CBxOpponents;
    @FXML
    private CheckBox ChVisible;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBxOpponents.getItems().addAll("0","1","2");
        CBxOpponents.getSelectionModel().selectFirst();

    }    
    @FXML
    private void switchToJuego() throws IOException {
        
        Configuracion configuration = new Configuracion(Integer.parseInt(CBxOpponents.getValue()), ChVisible.isSelected());
        System.out.println(configuration);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathSettigns))){
            out.writeObject(configuration);
            out.flush();

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }finally{
        App.setRoot("Juego");
        }  
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
}
