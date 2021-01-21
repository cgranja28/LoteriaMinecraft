package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.mycompany.modelo.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
public class PrimaryController {
    private String user;
    @FXML
    private TextField tusername;
    @FXML
    private Button bsettings;
    @FXML
    private Button primaryButton;
    @FXML
    private Button bexit;
    @FXML
    private Label errorLabel;

    @FXML
    private void switchToSettings() throws IOException{
        user = tusername.getText();
        
        if(!user.equals("")){
        try {
            FileWriter writer = new FileWriter(App.pathJuego, false);
            writer.write(user);
            writer.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally{
                App.setRoot("settings");
            }
        }else{
            errorLabel.setText("DEBE INGRESAR UN NOMBRE");
        }
            
        
    }
    
    @FXML
    private void switchToReporte() throws IOException {
        App.setRoot("report");
    }
    

    public String getUser() {
        return user;
    }
    
        
}
