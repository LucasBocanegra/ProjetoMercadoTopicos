
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.starcode.logic.Cliente;
import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;
import br.com.starcode.logic.RegistroVenda;

public class Teste_Inclus�o_RegistroDeVenda {
	
	private RegistroVenda RV;	
	
	@Before
	public void Criacao () {
		Mercado m = new Mercado();		
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

	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/	
	@Test
	public void CTRVI1() {
		RV = new RegistroVenda("0;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI2() {
		RV = new RegistroVenda("-1;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		
		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI3() {
		RV = new RegistroVenda("1;Arroz;37413815869;32/05/2015;0;7.00;1;5.00;");		
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI4() {
		RV = new RegistroVenda("1;Arroz;37413815869;05/13/2015;0;7.00;1;5.00;");		
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI5() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2010;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI6() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2016;0;7.00;1;5.00;");	
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI7() {
		RV = new RegistroVenda("1;Arroz;37413815869;30/02/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI8() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = Exception.class)
	public void CTRVI9() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;");		
	}
	
	@Test(expected = Exception.class)
	public void CTRVI10() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;2;2.00;3;7.00;4;");		
	}
	
	@Test(expected = Exception.class)
	public void CTRVI11() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;0;7.00;6;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI12() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;-1;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI13() {
		RV = new RegistroVenda("2;Arroz;37413815869;00/06/2015;0;7.00;1;5.00;");		
	}
	
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI14() {
		RV = new RegistroVenda("2;Arroz;37413815869;01/06/2015;0;7.00;1;5.00;");		
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI15() {
		RV = new RegistroVenda("3;Arroz;37413815869;31/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI16() {
		RV = new RegistroVenda("4;Arroz;37413815869;09/00/2015;0;7.00;1;5.00;");		
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI17() {
		RV = new RegistroVenda("5;Arroz;37413815869;09/01/2015;0;7.00;1;5.00;");
		assertEquals(RV.getNumero(),5);
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI18() {
		RV = new RegistroVenda("6;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");
		assertEquals(RV.getNumero(),6);
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI19() {
		RV = new RegistroVenda("7;Arroz;37413815869;09/06/2015;0;7.00;");		
	}
	/*ESTA DANDO ERRO FAVOR COMENTAR A FUNCIONALIDADE*/
	@Test()
	public void CTRVI20() {
		RV = new RegistroVenda("8;Arroz;37413815869;09/06/2015;0;0.01;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI21() {
		RV = new RegistroVenda("Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVI22() {
		RV = new RegistroVenda("0;Arroz;37413815869;09/06/2015;7.00;5.00;");		
	}
	


}
