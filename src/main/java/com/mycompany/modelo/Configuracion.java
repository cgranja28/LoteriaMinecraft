
package com.mycompany.modelo;
public class Configuracion {
    private int numero_de_oponentes;
    private boolean visibilidad;
    
    //CONSTRUCTOR
    public Configuracion(int numero_de_oponentes) {
        this.numero_de_oponentes = numero_de_oponentes;
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
}
