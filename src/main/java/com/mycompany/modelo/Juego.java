package com.mycompany.modelo;
import java.util.*;
public class Juego {
    private int id_juego;
    private Usuario usuario;
    private Mazo mazo;
   //La variable alineacion esta con mayusculas en el diagrama (Cambiar)
    private Alineacion alineacion;
    private Configuracion configuracion;
    private double duracion;
    private Date fecha;
    
    //CONSTRUCTOR

    public Juego() {
    }
    //METODOS
        //GETTERS AND SETTERS 
        public int getId_juego() {
            return id_juego;
        }
        /////////////////////////////////////////////////////
        public void setId_juego(int id_juego) {
            this.id_juego = id_juego;
        }
        /////////////////////////////////////////////////////
        public Usuario getUsuario() {
            return usuario;
        }
        /////////////////////////////////////////////////////
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
        /////////////////////////////////////////////////////
        public Mazo getMazo() {
            return mazo;
        }
        /////////////////////////////////////////////////////
        public void setMazo(Mazo mazo) {
            this.mazo = mazo;
        }
        /////////////////////////////////////////////////////
        public Alineacion getAlineacion() {
            return alineacion;
        }
        /////////////////////////////////////////////////////
        public void setAlineacion(Alineacion alineacion) {
            this.alineacion = alineacion;
        }
        /////////////////////////////////////////////////////
        public Configuracion getConfiguracion() {
            return configuracion;
        }
        /////////////////////////////////////////////////////
        public void setConfiguracion(Configuracion configuracion) {
            this.configuracion = configuracion;
        }
        /////////////////////////////////////////////////////
        public double getDuracion() {
            return duracion;
        }
        /////////////////////////////////////////////////////
        public void setDuracion(double duracion) {
            this.duracion = duracion;
        }
        /////////////////////////////////////////////////////
        public Date getFecha() {
            return fecha;
        }
        /////////////////////////////////////////////////////
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
        
        //INICIAR JUEGO 
        public void iniciarJuego() {
            
        }
        /////////////////////////////////////////////////////
        //LOTERIA
        public void loteria(){
        }
        
}
