/*	--CLASSE PRODUTO--
 * 
 *  Desc.: Está classe representa um produto.
 *  	   Um produto como ser comercializado (status) e  estocado (estoque)*/

package br.com.starcode.logic;

public class Produto {
	
	private int codigo;
	private String descricao;
	private double precoCompra;
	private double precoVenda;
	private String unidade;
	private double estoque;
	private int status;
	
	Produto(int codigo,String descricao, double precoCompra, double precoVenda, String unidade,
			double estoque, int status){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.unidade = unidade;
		this.estoque = estoque;
		this.status = status;		
	}
	
	public void alteraProduto(int codigo, String descricao, double precoCompra, double precoVenda,
			String unidade, double estoque, int status){
		
	}
	
	public void estoque(int codigo, double estoque){}
}
