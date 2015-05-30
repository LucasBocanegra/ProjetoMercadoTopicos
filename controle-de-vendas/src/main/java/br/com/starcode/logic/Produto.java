/*	--CLASSE PRODUTO--
 * 
 *  Desc.: Est� classe representa um produto.
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
	
	public Produto(int codigo,String descricao, double precoCompra, double precoVenda, String unidade,
			double estoque, int status) throws RuntimeException{	
		
		setCodigo(codigo);
		setDescricao(descricao);
		setPrecoCompra(precoCompra);
		setPrecoVenda(precoVenda);
		setUnidade(unidade);
		setEstoque(estoque);
		setStatus(status);				
	}
	
	public void alteraProduto(int codigo, String descricao, double precoCompra, double precoVenda,
			String unidade, double estoque, int status)throws RuntimeException{
		
		setCodigo(codigo);
		setDescricao(descricao);
		setPrecoCompra(precoCompra);
		setPrecoVenda(precoVenda);
		setUnidade(unidade);
		setEstoque(estoque);
		setStatus(status);		
	}
	
	//obs: n�o seria necess�rio fornecer o c�digo do produto
	public void alteraEstoque(int codigo, double estoque)throws RuntimeException{
		if(codigo >= 0 && this.codigo == codigo && estoque >= 0)
			this.estoque = estoque;
		else
			throw new RuntimeException();
	}
	
	public void alteraEstoque(double estoque)throws RuntimeException{
		if(estoque >= 0)
			this.estoque = estoque;
		else
			throw new RuntimeException();
	}
		

	public int getCodigo()throws RuntimeException {
		return codigo;
	}
	
	//codigo nao pode ser repetido
	public void setCodigo(int codigo) throws RuntimeException{
		this.codigo = codigo;
	}

	public String getDescricao()throws RuntimeException {
		return descricao;
	}

	public void setDescricao(String descricao) throws RuntimeException {
		if(descricao.length() >= 3 && descricao.length() <= 64)
			this.descricao = descricao;
		else
			throw new RuntimeException();
	}

	public double getPrecoCompra()throws RuntimeException {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) throws RuntimeException{
		if(precoCompra >= 0)
			this.precoCompra = precoCompra;
		else
			throw new RuntimeException();
	}	

	public double getPrecoVenda() throws RuntimeException{
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) throws RuntimeException{
		if(precoVenda >= this.precoCompra)
			this.precoVenda = precoVenda;
		else
			throw new RuntimeException();
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) throws RuntimeException{
		if(unidade.length() == 2)
			this.unidade = unidade;
		else
			throw new RuntimeException();
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double estoque) throws RuntimeException{
		if(estoque >= 0)
			this.estoque = estoque;
		else
			throw new RuntimeException();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) throws RuntimeException {
		if(status == 1 || status == 0){
			if(status == 0 && estoque >= 0)
				throw new RuntimeException();
			else
				this.status = status;
		}
		else
			throw new RuntimeException();
			
	}	
	
}
