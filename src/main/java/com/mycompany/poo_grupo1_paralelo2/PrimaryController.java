package com.mycompany.poo_grupo1_paralelo2;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Juego");
    }
}
