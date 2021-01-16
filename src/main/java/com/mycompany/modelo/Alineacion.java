package com.mycompany.modelo;

import java.io.Serializable;
import java.util.*;

public class Alineacion implements Serializable {
    private int id;
    private String nombre;
    private ArrayList<List<Integer>> combinaciones;

    //CONSTRUCTOR
    public Alineacion(int id) {
        this.id = id;
        Scanner sc= new Scanner(System.in);
            System.out.println();
            System.out.println();
            try{ 
            int op = id;
            switch (op){
              //****************************************ALINEACION 1*****************************************************
              case 0:
                nombre="FILA";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
                combinaciones.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
                combinaciones.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
                combinaciones.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
                break;
              //****************************************ALINEACION 2*****************************************************
              case 1:
                nombre="COLUMNA";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(1, 5, 9, 13)));
                combinaciones.add(new ArrayList<>(Arrays.asList(2, 6, 10, 14)));
                combinaciones.add(new ArrayList<>(Arrays.asList(3, 7, 11, 15)));
                combinaciones.add(new ArrayList<>(Arrays.asList(4, 8, 12, 16)));
                break;
              //****************************************ALINEACION 3*****************************************************
              case 2:
                nombre="ESQUINAS";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(1, 4, 13,16)));
                break;
              //****************************************ALINEACION 4*****************************************************
              case 3    :
                nombre="JUNTAS 4 EN ESQUINAS";
                combinaciones= new ArrayList<List<Integer>>();
                combinaciones.add(new ArrayList<>(Arrays.asList(1, 2, 5, 6)));
                combinaciones.add(new ArrayList<>(Arrays.asList(3, 4, 7, 8)));
                combinaciones.add(new ArrayList<>(Arrays.asList(9, 10, 13, 14)));
                combinaciones.add(new ArrayList<>(Arrays.asList(11, 12, 15, 16)));
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

    public ArrayList<List<Integer>> getCombinaciones() {
        return combinaciones;
    }

    public void setCombinaciones(ArrayList<List<Integer>> combinaciones) {
        this.combinaciones = combinaciones;
    }

 }