package br.com.starcode.bronzatoTest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import br.com.starcode.logic.Cliente;
import br.com.starcode.logic.Mercado;
import br.com.starcode.logic.Produto;

public class Teste_Inclus�o_Cliente{

	private Cliente cliente;
	
	@Test
	public void C1() {				
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C2() {
		cliente = new Cliente("L","13705137123","Av. S�o Carlos, 35", "(16)331432488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C3() {
		cliente = new Cliente("LeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandroLeandro",
						"13705137123","Av. S�o Carlos, 35", "(16)331432488","leSalazar@hotmail.com",0);
	}
	
	@Test(expected = Exception.class)
	public void C4() {
		cliente = new Cliente("Lendro","13705137123","Av. S�o Carlos, 35", "(16)331432488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C5() {
		cliente = new Cliente("L3ndro Salazar","13705137123","Av. S�o Carlos, 35", "(16)331432488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C6() {
		cliente = new Cliente("Lendro Salazar","137051371234","Av. S�o Carlos, 35", "(16)331432488748569854126","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C7() {
		cliente = new Cliente("Lendro Salazar","13705137124","Av. S�o Carlos, 35", "(16)331432488","leSalazarhotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C8() {
		Mercado m = new Mercado();			
		Cliente cliente2;
		
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","leSalazar@hotmail.com",1);
		cliente2 = new Cliente("Alef Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","leSalazar@hotmail.com",1);
		
		m.cadastrarCliente(cliente);
		m.cadastrarCliente(cliente2);
	}
	
	@Test(expected = Exception.class)
	public void C9() {
		cliente = new Cliente("Lendro Salazar","13705137123",
				"Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, "
						+ "35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35Av.S�oCarlos, 35","(16)331432488",
							"leSalazar@hotmail.com",1);
		
	}
	
	@Test(expected = Exception.class)
	public void C10() {
		cliente = new Cliente("Lendro Salazar","0000000000","Av. S�o Carlos*, 35","(16)331432488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C11() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)3314-32488","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C12() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)33143248a","leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C13() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","@leSalazar.hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C14() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","3leSalazar@hotmail.com",1);
	}
	
	@Test(expected = Exception.class)
	public void C15() {
	
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","le*Salazar@hotmail.com",0);
	}
	
	@Test(expected = Exception.class)
	public void C16() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","leSalazar@hotmail.comx",1);
	}
	
	@Test(expected = Exception.class)
	public void C17() {
		cliente = new Cliente("Lendro Salazar","13705137123","Av. S�o Carlos, 35","(16)331432488","leSalazar@hotmail.com",2);
	}	
		
}

