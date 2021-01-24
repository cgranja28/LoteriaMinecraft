package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import javafx.scene.control.Label;
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
    /**
     * Cambia de escena a configuracion
     */
    private void switchToSettings() throws IOException{
        user = tusername.getText();
        /**
         * Verifica que el campo de juego no este vacio
         */
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
    /**
     * Cambio de escena a reporte
     */
    private void switchToReporte() throws IOException {
        App.setRoot("report");
    }
    

    public String getUser() {
        return user;
    }
    
        
}
