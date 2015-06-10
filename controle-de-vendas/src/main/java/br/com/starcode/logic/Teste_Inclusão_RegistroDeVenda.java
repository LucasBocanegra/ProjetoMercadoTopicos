package br.com.starcode.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Teste_Inclus�o_RegistroDeVenda {
	private RegistroVenda RV;		
	private Produto Produto, Produto1, Produto2, Produto3, Produto4, Produto5,Produto6;
	
	@Before
	public void Criacao () {
		
		Produto = new Produto(0,"Arroz",5.00,6.99,"Un",100,1);
		Produto1 = new Produto(1,"Feijao",3.00,4.99,"Un",100,1);
		Produto2 = new Produto(2,"Milho",1.00,2.99,"Un",100,1);
		Produto3 = new Produto(3,"Caf�",1.50,2.99,"Un",100,1);
		Produto4 = new Produto(4,"Bolacha",0.50,0.99,"Un",100,1);
		Produto5 = new Produto(5,"Macarr�o",1.50,2.99,"Un",100,1);
		Produto6 = new Produto(6,"Leite",0.70,1.20,"Un",0,0);
		RV = new RegistroVenda("0;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		

	}

	
	
	@Test(expected = RuntimeException.class)
	public void CTRVA1() {
		RV.setNumero(-1);	
		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA2() {
		RV.setData("32/05/2015");		
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA3() {
		RV.setData("05/13/2015");		
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA4() {
		RV.setData("09/06/2010;0");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA5() {
		RV.setData("09/06/2016");	
		}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA6() {
		RV.setData("30/02/2015");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA7() {
		RV = new RegistroVenda("1;Arroz;37413815869;09/06/2015;0;7.00;1;5.00;");		
	}
	
	@Test(expected = Exception.class)
	public void CTRVA8() {
		RV.setQuantidadeItens(0);		
	}
	
	@Test(expected = Exception.class)
	public void CTRVA9() {
		RV.setQuantidadeItens(5);
		ArrayList<Double> array1 = new ArrayList<Double>();	
		array1.add(1.00);
		array1.add(2.00);
		array1.add(7.00);
		array1.add(5.00);
		RV.setQuantidades(array1);
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		Produtos.add(Produto);
		Produtos.add(Produto1);
		Produtos.add(Produto2);
		Produtos.add(Produto3);
		Produtos.add(Produto4);
		RV.setProdutos(Produtos);
	}
	
	@Test(expected = Exception.class)
	public void CTRVA10() {
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		Produtos.add(Produto);
		Produtos.add(Produto6);
		RV.setProdutos(Produtos);		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA11() {
		RV.setData("00/06/2015");
	}
	
	@Test()
	public void CTRVA12() {
		RV.setData("01/06/2015");		
	}
	
	@Test()
	public void CTRVA13() {
		RV.setData("31/06/2015");		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA14() {
		RV.setData("10/00/2015");		
	}
	
	@Test()
	public void CTRVA15() {
		RV.setData("10/01/2015");		
	}
	
	@Test()
	public void CTRVA16() {
		RV.setData("10/12/2015");
	}
	
	@Test()
	public void CTRVA17() {
		ArrayList<Double> quantidades = new ArrayList<Double>();
		quantidades.add(7.00);
		RV.setQuantidades(quantidades);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(Produto);
		RV.setProdutos(produtos);
	}
	
	@Test()
	public void CTRVA18() {
		ArrayList<Double> quantidades = new ArrayList<Double>();
		quantidades.add(0.01);
		RV.setQuantidades(quantidades);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(Produto);
		RV.setProdutos(produtos);		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA19() {
		ArrayList<Double> quantidades = new ArrayList<Double>();
		quantidades.add(0.01);
		RV.setQuantidades(quantidades);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		RV.setProdutos(produtos);		
	}
	
	@Test(expected = RuntimeException.class)
	public void CTRVA20() {
		ArrayList<Double> quantidades = new ArrayList<Double>();
		RV.setQuantidades(quantidades);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(Produto);
		RV.setProdutos(produtos);			
	}
	


}
