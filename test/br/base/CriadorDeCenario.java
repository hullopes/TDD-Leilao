/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.base;

/**
 *
 * @author tatuapu
 */
class CriadorDeCenario {

    private Leilao leilao;
    
    public CriadorDeCenario(Leilao leilao) {
        this.leilao = leilao;
    }

    CriadorDeCenario propoe(Lance lance) {
        this.leilao.propoe(lance);
        return this;
    }

    Leilao constroi() {
        return this.leilao;
    }
    
}
