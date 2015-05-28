/**
 * 
 */
package mercado;

/**
 * @author ferrari
 *
 */
public class Produto {

	private int codigo;
	private String descricao;
	private double precoCompra;
	private double precoVenda;
	private String unidade;
	private double estoque;
	private int status;

	// implementacao basica, sem validacoes
	public Produto(int codigo, String descricao, double precoCompra, 
			double precoVenda, String unidade, double estoque, 
			int status) {
		try {
			this.codigo = codigo;
			this.descricao = descricao;
			this.precoCompra = precoCompra;
			this.precoVenda = precoVenda;
			this.unidade = unidade;
			this.estoque = estoque;
			this.status = status;

		} catch (Exception e) {
			throw new RuntimeException();	
		}
	}
	
	// implementacao basica, sem validacoes
	public void alteraProduto(int codigo, String descricao, double precoCompra, 
			double precoVenda, String unidade, double estoque, 
			int status) {
		try {
			this.codigo = codigo;
			this.descricao = descricao;
			this.precoCompra = precoCompra;
			this.precoVenda = precoVenda;
			this.unidade = unidade;
			this.estoque = estoque;
			this.status = status;

		} catch (Exception e) {
			throw new RuntimeException();	
		}
	}
	
	// implementacao basica, sem validacoes
	public void alteraEstoque(int codigo, double estoque) {
		try {
			this.estoque = estoque;
		} catch (Exception e) {
			throw new RuntimeException();	
		}
	}


	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPrecoCompra() {
		return precoCompra;
	}


	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}


	public double getPrecoVenda() {
		return precoVenda;
	}


	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public String getUnidade() {
		return unidade;
	}


	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}


	public double getEstoque() {
		return estoque;
	}


	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


}
