/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class Leilao {
        private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
        public void propoe(Lance lance) {
		getLances().add(lance);
	}

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the lances
     */
    public List<Lance> getLances() {
        return lances;
    }
}
