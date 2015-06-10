package br.com.starcode.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class Teste_Inclusão_Produto{

	private Produto Produto;
	@Test
	public void CTPI1() {
		Produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
		assertEquals(Produto.getCodigo(),0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI2() {
		Produto = new Produto(-1,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI3() {
		Produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI4() {
		Produto = new Produto(1,"AB",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI5() {
		Produto = new Produto(1,"Abcdefghijklmnopqrstuvwxyz123456789abcdefghijklmnopqrstuvwxyz",
					5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI6() {
		Produto = new Produto(1,"*Arroz",-5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI7() {
		Produto = new Produto(1,"Arroz",5.00,-6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI8() {
		Produto = new Produto(1,"Arroz",5.00,4.00,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI9() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"ABC",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI10() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"12",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI11() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"Un",-1,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI12() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"Un",10,3);
	}
	
	@Test(expected = Exception.class)
	public void CTPI13() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"Un",0,0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI14() {
		Produto = new Produto(1,"Arroz",5.00,6.99,"Un",0,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI15() {
		Produto = new Produto(2,"abc",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI16() {
		Produto = new Produto(2,"AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefig",
				5.00,6.99,"Un",10,1);
		assertEquals(Produto.getCodigo(), 2);
	}
	
	@Test(expected = Exception.class)
	public void CTPI17() {
		Produto = new Produto(3,"AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefigh",
				5.00,5.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI18() {
		Produto = new Produto(-1,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI19() {
		Produto = new Produto(3,"Arroz",0.01,6.99,"Un",10,1);
		assertEquals(Produto.getCodigo(),3);
	}
	
	@Test(expected = Exception.class)
	public void CTPI20() {
		Produto = new Produto(4,"Arroz",0.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI21() {
		Produto = new Produto(4,"Arroz",0.01,0.01,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI22() {
		Produto = new Produto(5,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI23() {
		Produto = new Produto(5,"Arroz",5.00,6.99,"Un",0.00,0);
		assertEquals(Produto.getCodigo(),5);
	}
	
	@Test(expected = Exception.class)
	public void CTPI24() {
		Produto = new Produto(6,"Arroz",5.00,6.99,"Un",-0.01,0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI25() {
		Produto = new Produto(7	,"",5.00,6.99,"Un",10,0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI26() {
		Produto = new Produto(7,"Arroz",5.00,6.99,"",10,0);
	}
		
	
}

