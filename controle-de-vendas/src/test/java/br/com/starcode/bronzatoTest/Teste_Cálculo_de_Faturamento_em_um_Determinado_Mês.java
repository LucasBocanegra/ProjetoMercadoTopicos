package br.com.starcode.bronzatoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.starcode.logic.Cliente;
import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;
import br.com.starcode.logic.RegistroVenda;

public class Teste_C�lculo_de_Faturamento_em_um_Determinado_M�s{

	private Mercado m;
	
	@Before
	public void Criacao () {
		
		m = new Mercado();
		
		Produto produto, Produto1, Produto2, Produto3, Produto4, Produto5,Produto6;
		
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",100,1);
		Produto1 = new Produto(1,"Feijao",3.00,4.99,"Un",100,1);
		Produto2 = new Produto(2,"Milho",1.00,2.99,"Un",100,1);
		Produto3 = new Produto(3,"Cafe",1.50,2.99,"Un",100,1);
		Produto4 = new Produto(4,"Bolacha",0.50,0.99,"Un",100,1);
		Produto5 = new Produto(5,"Macarrao",1.50,2.99,"Un",100,1);
		Produto6 = new Produto(6,"Leite",0.70,1.20,"Un",0,0);

		m.cadastrarProduto(produto);
		m.cadastrarProduto(Produto1);
		m.cadastrarProduto(Produto2);
		m.cadastrarProduto(Produto3);
		m.cadastrarProduto(Produto4);
		m.cadastrarProduto(Produto5);
		m.cadastrarProduto(Produto6);
		
		Cliente c = new Cliente("matheus santos", "37413815869", "av. xyz", "(16)997765478", "matheus@ufscar.com.br", 1);
		
		m.cadastrarCliente(c);
	}
	
	@Test
	public void Con1() {
		RegistroVenda rv = new RegistroVenda("0;37413815869;09/06/2015;1;7.00;1;5.00;",m);
		m.cadastrarRegistroVenda(rv);
		System.out.println(m.calculaFaturamento(06));
		assertTrue(m.calculaFaturamento(06)==59.88);
	}
	
	@Test 
	public void Con2() {
		assertTrue(m.calculaFaturamento(00)==0);
	}
	
	@Test 
	public void Con3() {
		assertTrue(m.calculaFaturamento(13)==0);
	}	
	
	
}

