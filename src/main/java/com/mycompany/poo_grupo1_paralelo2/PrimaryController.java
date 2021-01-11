package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.mycompany.modelo.*;
import java.util.ArrayList;
public class PrimaryController {

    @FXML
    private TextField tusername;
    @FXML
    private Button bsettings;
    @FXML
    private Button primaryButton;
    @FXML
    private Button bexit;

    @FXML
    private void switchToSecondary() throws IOException {
        Usuario user = new Usuario(tusername.getText(), new Tabla(false,new ArrayList<Carta>() ,new ArrayList<Boolean> ()));
        System.out.println(user);
        App.setRoot("Juego");
    }
    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("settings");
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
    
        
}
