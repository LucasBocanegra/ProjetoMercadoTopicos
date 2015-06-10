package br.com.starcode.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Teste_Alteração_Produto{

	private Produto Produto;
	@Before
	public void Criacao() {
		Produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPA1() {
		Produto.setCodigo(-1);
	}
	

	@Test(expected = Exception.class)
	public void CTPA2() {
		Produto.setDescricao("AB");
	}
	
	@Test(expected = Exception.class)
	public void CTPA3() {
		Produto.setDescricao("Abcdefghijklmnopqrstuvwxyz123456789abcdefghijklmnopqrstuvwxyz");
	}
	
	@Test(expected = Exception.class)
	public void CTPA4() {
		Produto.setDescricao("*Arroz");
	}
	
	@Test(expected = Exception.class)
	public void CTPA5() {
		Produto.setPrecoVenda(-6.99);
	}
	
	@Test(expected = Exception.class)
	public void CTPA6() {
		Produto.setPrecoVenda(4.00);
	}
	
	@Test(expected = Exception.class)
	public void CTPA7() {
		Produto.setUnidade("ABC");
	}
	
	@Test(expected = Exception.class)
	public void CTPA8() {
		Produto.setUnidade("12");
	}
	
	@Test(expected = Exception.class)
	public void CTPA9() {
		Produto.setEstoque(-1);
	}
	
	@Test(expected = Exception.class)
	public void CTPA10() {
		Produto.setStatus(3);
	}
	
	@Test()
	public void CTPA11() {
		Produto.setEstoque(0);
		Produto.setStatus(0);

	}
	
	@Test(expected = Exception.class)
	public void CTPA12() {
		Produto.setEstoque(0);
		Produto.setStatus(1);
	}
	
	@Test(expected = Exception.class)
	public void CTPA13() {
		Produto.setDescricao("abc");
	}
	
	@Test()
	public void CTPA14() {
		Produto.setDescricao("AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefig");
		assertEquals(Produto.getCodigo(), 0);
	}
	
	@Test(expected = Exception.class)
	public void CTPA15() {
		Produto.setDescricao("AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefigh");
	}
	
	@Test()
	public void CTPA16() {
		Produto.setPrecoCompra(0.01);	
	}
	@Test(expected = Exception.class)
	public void CTPA17() {
		Produto.setPrecoCompra(0.00);
	}
	
	@Test()
	public void CTPA18() {
		Produto.setPrecoCompra(0.01);
		Produto.setPrecoVenda(0.01);
	}
	
	@Test(expected = Exception.class)
	public void CTPA19() {
		Produto.setUnidade("U");
	}
	
	@Test()
	public void CTPA20() {
		Produto.setEstoque(0.00);
		Produto.setStatus(0);
		assertEquals(Produto.getStatus(),0);
	}
	
	@Test(expected = Exception.class)
	public void CTPA21() {
		Produto.setEstoque(-0.01);
	}
	
	@Test(expected = Exception.class)
	public void CTPA22() {
		Produto.setDescricao("");
	}
	
	@Test(expected = Exception.class)
	public void CTPA23() {
		Produto.setUnidade("");
	}
		
	
}

