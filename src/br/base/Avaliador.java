/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class Avaliador {
     private double menorLance = Double.MAX_VALUE;
     private double maiorLance = Double.MIN_VALUE;
     
     public void avalia(Leilao l){
        List<Lance> lances = l.getLances();
        
                
        for(Lance lance: lances){
            maiorLance = (lance.getValor()>maiorLance) ? lance.getValor() : maiorLance;
            menorLance = (lance.getValor()<menorLance) ? lance.getValor() : menorLance;
        }
        
    }
    public double getMaior(){
        return maiorLance;
    }
    public double getMenor(){
        return menorLance;
    }
    
}
