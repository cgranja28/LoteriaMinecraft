module com.mycompany.poo_grupo1_paralelo2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.poo_grupo1_paralelo2 to javafx.fxml;
    exports com.mycompany.poo_grupo1_paralelo2;
}