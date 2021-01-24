/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_grupo1_paralelo2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
/**
 * 
 * @author Grupo1
 */
public class ReportController{
    @FXML
    private ListView<String> listReport;
    ObservableList list = FXCollections.observableArrayList();
    public void initialize() {
     leerReporte();           
    }    

    @FXML
    /**
     * Cambio de escena a la principal
     */
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
        
    }
    
    /**
     * Lee el report.txt en donde se guarda la info del juego
     */
    private void leerReporte(){
        try {
            FileReader reader = new FileReader(App.pathReport);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) { 
                list.removeAll(list);
                list.add(line);
                listReport.getItems().addAll(list);
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
    }

}
