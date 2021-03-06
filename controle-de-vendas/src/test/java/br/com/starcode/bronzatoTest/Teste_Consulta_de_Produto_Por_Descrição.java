package br.com.starcode.bronzatoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.starcode.logic.Cliente;
import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;

public class Teste_Consulta_de_Produto_Por_Descri��o{

	private Mercado m;
	
	@Before
	public void Criacao () {
		
		m = new Mercado();
		
		Produto produto, Produto1, Produto2, Produto3, Produto4, Produto5,Produto6, Produto7;
		
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",100,1);
		Produto1 = new Produto(1,"Feijao",3.00,4.99,"Un",100,1);
		Produto2 = new Produto(2,"Milho",1.00,2.99,"Un",100,1);
		Produto3 = new Produto(3,"Cafe",1.50,2.99,"Un",100,1);
		
		Produto4 = new Produto(4,"Bolacha",0.50,0.99,"Un",0,0);
		Produto5 = new Produto(5,"Macarrao",1.50,2.99,"Un",0,1);
		Produto6 = new Produto(6,"Leite",0.70,1.20,"Un",10,1);
		Produto7 = new Produto(7,"Leite",0.60,1.00,"Un",10,1);

		m.cadastrarProduto(produto);
		m.cadastrarProduto(Produto1);
		m.cadastrarProduto(Produto2);
		m.cadastrarProduto(Produto3);
		m.cadastrarProduto(Produto4);
		m.cadastrarProduto(Produto5);
		m.cadastrarProduto(Produto6);
		m.cadastrarProduto(Produto7);
		
		Cliente c = new Cliente("matheus santos", "37413815869", "av. xyz", "(16)997765478", "matheus@ufscar.com.br", 1);
		
		m.cadastrarCliente(c);
	}
	
	
	@Test
	public void Con1() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0); //Arroz
		assertTrue(m.consultaProdutos("Arroz").containsAll(array));		
	}
	
	@Test
	public void Con2() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0); //Arroz			
		assertFalse(m.consultaProdutos("AB").containsAll(array));
	}
	
	@Test
	public void Con3() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0); //Arroz			
		assertFalse(m.consultaProdutos("CajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuCajuu").containsAll(array));
	}
	
	@Test
	public void Con4() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(6); //leite 1
		array.add(7); //leite 2	
		m.consultaProdutos("Leite").containsAll(array);
		
		assertTrue(m.consultaProdutos("Leite").containsAll(array));
		
	}
	
	@Test
	public void Con5() {
		ArrayList<Integer> array = new ArrayList<Integer>();					
		assertFalse(m.consultaProdutos("").containsAll(array) && !array.isEmpty());
	}
	
	@Test 
	public void Con6() {
		ArrayList<Integer> array = new ArrayList<Integer>();					
		assertFalse(m.consultaProdutos("Macarrao").containsAll(array) && !array.isEmpty());;
	}
		
}

