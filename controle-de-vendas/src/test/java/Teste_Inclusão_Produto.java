
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;

public class Teste_Inclusão_Produto{

	private Produto produto;
	
	@Test
	public void CTPI1() {
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
		assertEquals(produto.getCodigo(),0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI2() {
		produto = new Produto(-1,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI3() {
		Mercado m = new Mercado();
		m.cadastrarProduto(new Produto(0,"Arroz",5.00,6.99,"Un",10,1));
		
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",10,1);
		m.cadastrarProduto(produto);
	}
	
	@Test(expected = Exception.class)
	public void CTPI4() {
		produto = new Produto(1,"AB",5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI5() {
		produto = new Produto(1,"Abcdefghijklmnopqrstuvwxyz123456789abcdefghijklmnopqrstuvwxyzaabcdefg",
					5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI6() {
		produto = new Produto(1,"*Arroz",-5.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI7() {
		produto = new Produto(1,"Arroz",5.00,-6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI8() {
		produto = new Produto(1,"Arroz",5.00,4.00,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI9() {
		produto = new Produto(1,"Arroz",5.00,6.99,"ABC",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI10() {
		produto = new Produto(1,"Arroz",5.00,6.99,"12",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI11() {
		produto = new Produto(1,"Arroz",5.00,6.99,"Un",-1,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI12() {
		produto = new Produto(1,"Arroz",5.00,6.99,"Un",10,3);
	}
	
	@Test
	public void CTPI13() {
		produto = new Produto(1,"Arroz",5.00,6.99,"Un",0,0);
	}
	
	@Test
	public void CTPI14() {
		produto = new Produto(1,"Arroz",5.00,6.99,"Un",0,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI15() {
		produto = new Produto(2,"ab",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI16() {
		produto = new Produto(2,"AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefig",
				5.00,6.99,"Un",10,1);
		assertEquals(produto.getCodigo(), 2);
	}
	
	@Test(expected = Exception.class)
	public void CTPI17() {
		produto = new Produto(3,"AbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigAbcdefigabcdefigh",
				5.00,5.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI18() {
		produto = new Produto(-1,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI19() {
		produto = new Produto(3,"Arroz",0.01,6.99,"Un",10,1);
		assertEquals(produto.getCodigo(),3);
	}
	
	@Test
	public void CTPI20() {
		produto = new Produto(4,"Arroz",0.00,6.99,"Un",10,1);
	}
	
	@Test(expected = Exception.class)
	public void CTPI21() {
		produto = new Produto(4,"Arroz",0.01,0.01,"U",10,1);
	}
	
	@Test
	public void CTPI22() {
		produto = new Produto(5,"Arroz",5.00,6.99,"Un",10,1);
	}
	
	@Test()
	public void CTPI23() {
		produto = new Produto(5,"Arroz",5.00,6.99,"Un",0.00,0);
		assertEquals(produto.getCodigo(),5);
	}
	
	@Test(expected = Exception.class)
	public void CTPI24() {
		produto = new Produto(6,"Arroz",5.00,6.99,"Un",-0.01,0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI25() {
		produto = new Produto(7	,"",5.00,6.99,"Un",10,0);
	}
	
	@Test(expected = Exception.class)
	public void CTPI26() {
		produto = new Produto(7,"Arroz",5.00,6.99,"",10,0);
	}
		
	
}

