package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        App.setRoot("Juego");
    }
    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("settings");
    }
}
