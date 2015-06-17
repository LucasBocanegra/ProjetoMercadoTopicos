package br.com.starcode.bronzatoTest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.starcode.logic.Produto;

public class Teste_Alteração_da_quantidade_em_estoque_dos_produtos{

	private Produto produto;
	
	@Before
	public void Criacao() {
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
	}
		
	@Test
	public void A1() {
		produto.alteraEstoque(0,0);
	}
	
	@Test(expected = Exception.class)
	public void A2() {
		produto.alteraEstoque(-1,0);
	}
		
	@Test(expected = Exception.class)
	public void A4() {
		produto.alteraEstoque(0,-1);
	}
	
}

