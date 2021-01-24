package com.mycompany.modelo;

import java.io.Serializable;
import java.util.*;
/**
 * 
 * @author Grupo1
 * 
 * 
 */
public class Alineacion implements Serializable {
    private int id;
    private String nombre;
    private ArrayList<List<Integer>> combinaciones;
    
  
    /**
     * CONSTRUCTOR
     * @param id
     * id necesario para crear alineacion deseada para el juego
     */
    public Alineacion(int id) {
        this.id = id;
        Scanner sc= new Scanner(System.in);
            System.out.println();
            System.out.println();
            try{ 
            int op = id;
            switch (op){
              //****************************************ALINEACION 1*****************************************************
              /**
               * Combinaciones posibles para la alineacion de Fila
               */
              case 0:
                nombre="FILA";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3)));
                combinaciones.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7)));
                combinaciones.add(new ArrayList<>(Arrays.asList(8, 9, 10, 11)));
                combinaciones.add(new ArrayList<>(Arrays.asList(12, 13, 14, 15)));
                break;
              //****************************************ALINEACION 2*****************************************************
              /**
               * Combinaciones posibles para la alineacion de Columna
               */
              case 1:
                nombre="COLUMNA";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(0, 4, 8, 12)));
                combinaciones.add(new ArrayList<>(Arrays.asList(1, 5, 9, 13)));
                combinaciones.add(new ArrayList<>(Arrays.asList(2, 6, 10, 14)));
                combinaciones.add(new ArrayList<>(Arrays.asList(3, 7, 11, 15)));
                break;
              //****************************************ALINEACION 3*****************************************************
              /**
               * Combinaciones posibles para la alineacion de Esquinas
               */
              case 2:
                nombre="ESQUINAS";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(0, 3, 12,15)));
                break;
              //****************************************ALINEACION 4*****************************************************
              /**
               * Combinaciones posibles para la alineacion juntas 4 en esquinas
               */
              case 3    :
                nombre="JUNTAS 4 EN ESQUINAS";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(0, 1, 4, 5)));
                combinaciones.add(new ArrayList<>(Arrays.asList(2, 3, 6, 7)));
                combinaciones.add(new ArrayList<>(Arrays.asList(8, 9, 12, 13)));
                combinaciones.add(new ArrayList<>(Arrays.asList(10, 11, 14, 15)));
                break; 
              default:
                System.out.println("\nOPCION INVALIDA DE ALINEACION\n");
                break;
              }
            }catch (InputMismatchException e) {
                System.out.println("\n**OPCION INVALIDA DE ALINEACION**\n");
                sc.next();
            }  
    }
    
    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return
     * retorna 
     */
    public ArrayList<List<Integer>> getCombinaciones() {
        return combinaciones;
    }

    public void setCombinaciones(ArrayList<List<Integer>> combinaciones) {
        this.combinaciones = combinaciones;
    }

 }