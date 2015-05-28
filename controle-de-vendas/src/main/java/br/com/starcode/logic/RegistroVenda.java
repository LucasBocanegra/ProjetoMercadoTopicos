package br.com.starcode.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistroVenda {
	
	private int numero;
	private Date data;
	private int quantidadeItens;
	private ArrayList<Double> quantidades;
	
	private Cliente cliente; //cpf do cliente
	private ArrayList<Produto> produtos;	//produtos comprados pelo cliente
	
	public RegistroVenda(){}
	
	public RegistroVenda(int numero, String data, int quantidadeItens,
			ArrayList<Double> quantidades, Cliente cliente, ArrayList<Produto> produtos) {
		
		setNumero(numero);
		setData(data);
		setQuantidadeItens(quantidadeItens);
		setQuantidades(quantidades);
		setCliente(cliente);
		setProdutos(produtos);
	}
	
	public RegistroVenda(String info){
		/*String info = numero do registro de venda, CPF do cliente, data da
		venda, c�odigo do produto 1, quantidade do produto 1, c�odigo do produto
		2, quantidade do produto 2, ..., c�odigo do produto n, quantidade do
		produto n, separado por ";" cada item*/
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) throws RuntimeException{
		if(numero > 0)
			this.numero = numero;
		else
			throw new RuntimeException();
	}

	public Date getData() {
		return data;
	}

	public void setData(String data) {
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  		
	    df.setLenient (false); // aqui o pulo do gato  
	    try {
			this.data =  df.parse(data);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens)throws RuntimeException {
		if (quantidadeItens > 0)
			this.quantidadeItens = quantidadeItens;
		else
			throw new RuntimeException();
	}

	public ArrayList<Double> getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(ArrayList<Double> quantidades)throws RuntimeException {
		this.quantidades = new ArrayList<Double>();
		boolean numOk = true;
		
		if(quantidades.size() == quantidadeItens){
			for (Double num : quantidades) {
				if(num <= 0)
					numOk = false;
			}
			//se todas as quantidades forem maiores que 0
			if(numOk == true)
				this.quantidades.addAll(quantidades);
			else 
				throw new RuntimeException();
		}else
			throw new RuntimeException();
			
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) throws RuntimeException {
		this.produtos = new ArrayList<Produto>();
		boolean prodOk = true;
		
		if(produtos.size() ==  quantidades.size()){
			for(int i=0; i< produtos.size();i++)
			{
				if(produtos.get(i).getEstoque() < quantidades.get(i)){
					prodOk = false;
					break;
				}
			}
			if(prodOk == true)
			{
				atualizaEstoque(produtos);
				this.produtos.addAll(produtos);					
			}
			else
				throw new RuntimeException();
		}		
	}	
	
	private void atualizaEstoque(ArrayList<Produto> produtos){
		for(int i=0; i< produtos.size();i++){
			Produto p = produtos.get(i);
			p.setEstoque(p.getEstoque()-quantidades.get(i));
			produtos.set(i, p);
		}
		
	}
}