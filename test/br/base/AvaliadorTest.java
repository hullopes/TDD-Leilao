/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.base;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tatuapu
 */
public class AvaliadorTest {
    
    @Test
    public void deveEntenderLancesEmOrdemCrescente(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 0.99));
        leilao.propoe(new Lance(maria, 1.00));
        leilao.propoe(new Lance(pedro, 5.00));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance crescente", 0.99, avaliador.getMenor(),0.001);
        assertEquals("Erro ao encontrar o maior lance crescente", 5.0, avaliador.getMaior(),0.001);
    }
    
    @Test
    public void deveEntenderLancesEmOrdemDecrescente(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 12.99));
        leilao.propoe(new Lance(maria, 10.00));
        leilao.propoe(new Lance(pedro, 5.00));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance crescente", 5.0, avaliador.getMenor(),0.001);
        assertEquals("Erro ao encontrar o maior lance crescente", 12.99, avaliador.getMaior(),0.001);
    }
    @Test
    public void deveEntenderLancesAleatorios(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 2.99));
        leilao.propoe(new Lance(maria, 1.00));
        leilao.propoe(new Lance(pedro, 5.00));
        leilao.propoe(new Lance(joao, 12.99));
        leilao.propoe(new Lance(maria, 11.00));
        leilao.propoe(new Lance(pedro, 51.00));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance aleatorio", 1.0, avaliador.getMenor(),0.001);
        assertEquals("Erro ao encontrar o maior lance aleatório", 51.0, avaliador.getMaior(),0.001);
    }
     @Test
    public void deveEntenderSoUmLance(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 12.99));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance com um só lance", 12.99, avaliador.getMenor(),0.001);
        assertEquals("Erro ao encontrar o maior lance com um só lance", 12.99, avaliador.getMaior(),0.001);
    }
    @Test
    public void deveEntenderDoisLancesLimitrofes(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 12.99));
        leilao.propoe(new Lance(maria, 12.991));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance com um só lance", 12.99, avaliador.getMenor(),0.00001);
        assertEquals("Erro ao encontrar o maior lance com um só lance", 12.991, avaliador.getMaior(),0.00001);
    }
    @Test
    public void deveCalcularValorMedio3Lances(){
        //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 12.99));
        leilao.propoe(new Lance(maria, 10.00));
        leilao.propoe(new Lance(pedro, 5.00));
        //Execução da ação
        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o valor médio entre 3 lances", 9.33, avaliador.getValorMedio(leilao),0.001);
    }
    @Test
    public void deveEncontrarOsTresMaioresLancesEntreQuatroAleatorios(){
         //cenário
        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
        
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 10.00));
        leilao.propoe(new Lance(pedro, 5.00));
    }
}
