/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.base;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author tatuapu
 */
public class AvaliadorTest {
    
    Avaliador avaliador;
    
    @Before
    public void antes(){
        this.avaliador = new Avaliador();
    }
    @After
    public void depois(){
        System.out.println("Depois");
    }
    @BeforeClass
    public static void antesDeTudo(){
        System.out.println("Antes de tudo");
    }
    @AfterClass
    public static void depoisDeTudo(){
        System.out.println("Depois de tudo");
    }
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
        this.avaliador.avalia(leilao);
        
        //Validação
        assertEquals("Erro ao encontrar o menor lance crescente", 0.99, avaliador.getMenor(),0.001);
        assertEquals("Erro ao encontrar o maior lance crescente", 5.0, avaliador.getMaior(),0.001);
    }
    
    @Test
    public void deveEntenderLancesEmOrdemDecrescente(){
        //cenário
        Usuario joao = new Usuario("João");
        Usuario maria= new Usuario("Maria");
        Usuario pedro= new Usuario("Pedro");        
        
        Leilao leilao = new CriadorDeCenario(new Leilao("")).propoe(new Lance(joao, 12.99)).propoe(new Lance(maria, 10.00))
                .propoe(new Lance(pedro, 5.00))
                .constroi();
        
//        
//        Leilao leilao = new Leilao("Leilão de Um Pastel de Leite Ninho com Nutela dos infernos");
//        
//        Usuario joao = new Usuario("João");
//        Usuario maria= new Usuario("Maria");
//        Usuario pedro= new Usuario("Pedro");
//        leilao.propoe(new Lance(joao, 12.99));
//        leilao.propoe(new Lance(maria, 10.00));
//        leilao.propoe(new Lance(pedro, 5.00));
        //Execução da ação
        this.avaliador.avalia(leilao);
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
        leilao.propoe(new Lance(joao, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400.00, maiores.get(0).getValor(),0.001);
        assertEquals(100.00, maiores.get(1).getValor(),0.001);
        assertEquals(10.00, maiores.get(2).getValor(),0.001);
    }
}
