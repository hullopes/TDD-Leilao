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
    private List<Lance> maiores;
     
     public void avalia(Leilao l){
        List<Lance> lances = l.getLances();
        
                
        for(Lance lance: lances){
            maiorLance = (lance.getValor()>maiorLance) ? lance.getValor() : maiorLance;
            menorLance = (lance.getValor()<menorLance) ? lance.getValor() : menorLance;
        }
        pegaOsMaioresLancesNo(l);//pegando os 3 maiores
    }
    public double getMaior(){
        return maiorLance;
    }
    public double getMenor(){
        return menorLance;
    }
    
    public double getValorMedio(Leilao leilao){
        double total = 0.0;
        List<Lance> lances = leilao.getLances();
        int i=0;
        for (Lance lance:lances){
            total+=lance.getValor();
            i++;
        }
        return total/i;
    }
    
    public List<Lance> getTresMaiores(){
        return this.maiores;
    }

    private void pegaOsMaioresLancesNo(Leilao l) {
            maiores = new ArrayList<Lance>(l.getLances());
            Collections.sort(maiores, new Comparator<Lance>(){
                public int compare(Lance o1, Lance o2){
                    if(o1.getValor() < o2.getValor()) return 1;
                    if(o1.getValor() > o2.getValor()) return -1;
                    return 0;
                }
            });
    }
    
}
