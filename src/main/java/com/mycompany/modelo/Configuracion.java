
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Random;

public class Configuracion  implements Serializable{
    private int numero_de_oponentes;
    private boolean visibilidad;
    private Alineacion alineacion;
    
    //CONSTRUCTOR
    public Configuracion(int numero_de_oponentes, boolean visibilidad){
        this.numero_de_oponentes = numero_de_oponentes;
        this.visibilidad = visibilidad;
        alineacion = crearAlineacion();
    }

    
    //METODOS
        //GETTERS AND SETTERS
        public int getNumero_de_oponentes() {
            return numero_de_oponentes;
        }
        /////////////////////////////////////////////////////
        public void setNumero_de_oponentes(int numero_de_oponentes) {
            this.numero_de_oponentes = numero_de_oponentes;
        }
        /////////////////////////////////////////////////////
        public boolean isVisibilidad() {
            return visibilidad;
        }
        /////////////////////////////////////////////////////
        public void setVisibilidad(boolean visibilidad) {
            this.visibilidad = visibilidad;
        }
        
        public Alineacion getAlineacion() {
        return alineacion;
        }

        public void setAlineacion(Alineacion alineacion) {
            this.alineacion = alineacion;
        }

        
        
        public Alineacion crearAlineacion(){
            Random rand = new Random();
            int id_alinea = rand.nextInt(3);
            Alineacion alinea = new Alineacion(id_alinea);
            return alinea;
        }

    @Override
    public String toString() {
        return "Configuracion{" + "numero_de_oponentes=" + numero_de_oponentes + ", visibilidad=" + visibilidad + '}';
    }
        
}
