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
    private Button breport;
    
    /*@FXML
    private void switchToSettings() throws IOException {
        n_opponents = new ArrayList<Integer>();
        n_opponents.add(0);
        n_opponents.add(1);
        n_opponents.add(2);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("settings.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(new SettingsController(n_opponents));//se asigna el controlador enviando las listas que necesita
        App.setRoot("settings");
    }*/
    @FXML
    private void switchToSettings() throws IOException {
        user = tusername.getText();
            try {
            FileWriter writer = new FileWriter(App.pathJuego, false);
            writer.write(user);
            writer.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally{
                App.setRoot("settings");
            }
        
    }
    
    @FXML
    private void switchToReporte() throws IOException {
        App.setRoot("report");
    }
    
    

    
    /*
    Persona p = new Persona(txtCedula.getText(), txtNombre.getText(), cmbEstado.getValue());
        System.out.println("Nueva Persona:" + p);
        FileWriter fw = null;
        try {

            //escribir en el archivo
            fw = new FileWriter(App.pathPersonas, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(p.escribirLinea());
            bw.newLine();
            bw.close();
            //mostrar informacion
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operacion");
            alert.setContentText("Nueva persona agregada exitosamente");

            alert.showAndWait();

            App.setRoot("primary");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    */

    public String getUser() {
        return user;
    }
    
        
}
