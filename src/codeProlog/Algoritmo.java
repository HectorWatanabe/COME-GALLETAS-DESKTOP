/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeProlog;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Hector
 */
public class Algoritmo {
    
    String consult;
    String encontrarCamino;
    
    public Algoritmo(){
        consult = "consult('algoritmo.pl')";
        encontrarCamino = "encontrar_mejor_camino('38','3', R, S).";
    }
    
    public void conexion(){
        try{
            Query conexion = new Query(consult);
            conexion.hasMoreSolutions();
        }catch(Exception e){
            
        }
    }
    
    public Term[] encontrarCamino(){
        try{
            Query ejecutar = new Query(encontrarCamino);
            if(ejecutar.hasSolution()){
                Term[] ruta = ejecutar.oneSolution().get("S").toTermArray();
                return ruta;
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
            return null;
    }
}
