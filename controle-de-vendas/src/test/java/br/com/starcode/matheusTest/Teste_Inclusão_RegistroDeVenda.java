package br.com.starcode.matheusTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.starcode.logic.Cliente;
import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;
import br.com.starcode.logic.RegistroVenda;

public class Teste_Inclusão_RegistroDeVenda {
	
	private RegistroVenda RV;	
	private Mercado m = new Mercado();		
	private Produto produto, Produto1, Produto2, Produto3, Produto4, Produto5,Produto6;
	
	
	@Before
	public void Criacao () {
		
		produto = new Produto(0,"Arroz",5.00,6.99,"Un",100,1);
		Produto1 = new Produto(1,"Feijao",3.00,4.99,"Un",100,1);
		Produto2 = new Produto(2,"Milho",1.00,2.99,"Un",100,1);
		Produto3 = new Produto(3,"Cafe",1.50,2.99,"Un",100,1);
		Produto4 = new Produto(4,"Bolacha",0.50,0.99,"Un",100,1);
		Produto5 = new Produto(5,"Macarrao",1.50,2.99,"Un",100,1);
		Produto6 = new Produto(6,"Leite",0.70,1.20,"Un",0,0);
		Produto6 = new Produto(7,"Tomate",0.70,1.20,"Un",0,0);
		
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
	public void CTRVI1() {
		RV = new RegistroVenda("0;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI2() {
		RV = new RegistroVenda("-1;37413815869;09/06/2015;0;7.00;1;5.00;");		
		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI3() {
		RV = new RegistroVenda("1;37413815869;32/05/2015;0;7.00;1;5.00;");		
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI4() {
		RV = new RegistroVenda("1;37413815869;05/13/2015;0;7.00;1;5.00;");		
		}
	
	@Test//(expected = RuntimeException.class)
	public void CTRVI5() {
		RV = new RegistroVenda("1;37413815869;09/06/2010;0;7.00;1;5.00;");		
	}
	
	@Test//(expected = RuntimeException.class)
	public void CTRVI6() {
		RV = new RegistroVenda("1;37413815869;09/06/2016;0;7.00;1;5.00;");	
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI7() {
		RV = new RegistroVenda("1;37413815869;30/02/2015;0;7.00;1;5.00;");		
	}
	
	@Test//(expected = RuntimeException.class)
	public void CTRVI8() {
		RV = new RegistroVenda("1;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = Exception.class)
	public void CTRVI9() {
		RV = new RegistroVenda("1;37413815869;09/06/2015;");		
	}
	
	@Test(expected = Exception.class)	
	public void CTRVI10() {
		RV = new RegistroVenda("1;37413815869;09/06/2015;0;7.00;1;5.00;2;2.00;3;7.00;4;");		
	}
	
	//@Test(expected = Exception.class)
	@Test
	public void CTRVI11() {
		RV = new RegistroVenda("1;37413815869;09/06/2015;0;7.00;6;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI12() {
		RV = new RegistroVenda("1;37413815869;09/06/2015;-1;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI13() {
		RV = new RegistroVenda("2;37413815869;00/06/2015;0;7.00;1;5.00;");		
	}
	
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI14() {
		RV = new RegistroVenda("2;37413815869;01/06/2015;0;7.00;1;5.00;");	
		//Esse caso de teste é pra testar o dia 01 na Análise do Valor limite
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test(expected = RuntimeException.class)
	public void CTRVI15() {
		RV = new RegistroVenda("3;37413815869;31/06/2015;0;7.00;1;5.00;");	
		//Esse caso de teste é pra testar o dia 31 na Análise do Valor limite
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI16() {
		RV = new RegistroVenda("4;37413815869;10/00/2015;0;7.00;1;5.00;");		
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI17() {
		RV = new RegistroVenda("5;37413815869;10/01/2015;0;7.00;1;5.00;");
		assertEquals(RV.getNumero(),5);
		//Esse caso de teste é pra testar o mes 01 na Análise do Valor limite
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI18() {
		RV = new RegistroVenda("6;37413815869;10/12/2015;0;7.00;1;5.00;");
		assertEquals(RV.getNumero(),6);
		//Esse caso de teste é pra testar o mes 12 na Análise do Valor limite
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI19() {
		RV = new RegistroVenda("7;37413815869;09/06/2015;0;7.00;");		
		//Esse caso de teste é pra testar o valor na quantidade de produtos, ou seja
		//um produto apenas comprado
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI20() {
		RV = new RegistroVenda("8;37413815869;09/06/2015;0;0.01;");	
		//Esse caso de teste é pra testar o valor 0.01 na quantidade do produto
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI21() {
		RV = new RegistroVenda("Arroz;37413815869;09/06/2015;0;0.01;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI22() {
		RV = new RegistroVenda("9;37413815869;09/06/2015;0.01;");		
	}
	
	//NOVOS CASOS

	@Test(expected = RuntimeException.class)
	public void CTRVI23() {
		RV = new RegistroVenda("10;37413815869;09/06/2015;7.00;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI24() {
		RV = new RegistroVenda("10;Arroz;37413234323;09/06/2015;7.00;5.00;");		
	}

}
