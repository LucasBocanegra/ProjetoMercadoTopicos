package br.com.starcode.logic;

import java.util.ArrayList;

public class Mercado {

	private ArrayList<Cliente> clientes;
	private ArrayList<Produto> produtos;
	private ArrayList<RegistroVenda> registrosVendas;
	
	public Mercado() {
		
		clientes = new ArrayList<Cliente>();
		produtos = new ArrayList<Produto>();
		registrosVendas = new ArrayList<RegistroVenda>();
	}

	
	public double calculaFaturamento(int mes)throws RuntimeException{
		double faturamento = 0.0;
		
		if(mes > 0 && mes < 12)
		{		
			for (RegistroVenda reg : registrosVendas) {
				if ((reg.getData().getMonth()+1) == mes)
				{
					faturamento += reg.valorTotalCompra();
				}
			}
		}
		return faturamento;
	}	

	
	public ArrayList<Integer> consultaProdutos(String descricao){
		ArrayList<Integer> p =  new ArrayList<Integer>();
		for (Produto prod : produtos) {
			if(prod.getDescricao().indexOf(descricao) == 0)
				p.add(prod.getCodigo());
		}
		if(p.isEmpty())
			p.add(-1);
		
		return p;
	} 
	
	public void cadastrarCliente(Cliente c){
		this.clientes.add(c);
	}
	
	public void deleteCliente(Cliente c)throws RuntimeException{
		
		if(this.clientes.indexOf(c) != -1)
		{
			this.clientes.remove(c);
		}else
			throw new RuntimeException();
	}
	
	public void deleteCliente(Integer index)throws RuntimeException{
		
		if(index >= 0 && index < this.clientes.size())
		{
			this.clientes.remove(index);
		}else
			throw new RuntimeException();
	}
	
	public void cadastrarProduto(Produto p){
		this.produtos.add(p);
	}
	
	public void deleteProduto(Produto p)throws RuntimeException{
		
		if(this.produtos.indexOf(p) != -1)
		{
			this.produtos.remove(p);
		}else
			throw new RuntimeException();
	}
	
	public void deleteProduto(Integer index)throws RuntimeException{
		
		if(index >= 0 && index < this.produtos.size())
		{
			this.produtos.remove(index);
		}else
			throw new RuntimeException();
	}
	
	
	public void cadastrarRegistroVenda(RegistroVenda reg){
		this.registrosVendas.add(reg);
	}
	
	public void deleteRegistroVenda(RegistroVenda reg)throws RuntimeException{
		
		if(this.registrosVendas.indexOf(reg) != -1)
		{
			this.registrosVendas.remove(reg);
		}else
			throw new RuntimeException();
	}
	
	public void deleteRegistroVenda(Integer index)throws RuntimeException{
		
		if(index >= 0 && index < this.registrosVendas.size())
		{
			this.registrosVendas.remove(index);
		}else
			throw new RuntimeException();
	}
	
	/* verifica se no vetor de produtos cadastras existe algum produto com o codigo passado pelo parametro*/
	public boolean existeProtudo(int codigo){
		boolean existe = false;
		for (Produto p : produtos) {
			if(p.getCodigo() == codigo)
				existe = true;
		}
		return existe;
	}
	/* verifica se no vetor de clientes cadastrados existe algum cliente com o cpf passado pelo parametro*/
	public boolean existeCliente(String cpf){
		boolean existe = false;
		for (Cliente c : clientes) {
			if(c.getCpf().equalsIgnoreCase(cpf))
				existe = true;
		}
		return existe;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<RegistroVenda> getregistrosVendas() {
		return registrosVendas;
	}

	public void setregistrosVendas(ArrayList<RegistroVenda> registrosVendas) {
		this.registrosVendas = registrosVendas;
	}
	
}
