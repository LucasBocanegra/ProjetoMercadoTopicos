package br.com.starcode.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.management.RuntimeErrorException;

public class RegistroVenda {
	
	private int numero;
	private Date data;
	private int quantidadeItens;
	private ArrayList<Double> quantidades;
	
	private Cliente cliente; //cpf do cliente
	private ArrayList<Produto> produtos;	//produtos comprados pelo cliente
	
	
	public RegistroVenda(int numero, String data, int quantidadeItens,
			ArrayList<Double> quantidades, Cliente cliente, ArrayList<Produto> produtos) throws RuntimeException {
		
		setNumero(numero);
		setData(data);
		setQuantidadeItens(quantidadeItens);
		setQuantidades(quantidades);
		setCliente(cliente);
		setProdutos(produtos);
	}
	
	/*cadastra um registro venda no mercado indicado*/
	public RegistroVenda(int numero, String data, int quantidadeItens,
			ArrayList<Double> quantidades, Cliente cliente, ArrayList<Produto> produtos, Mercado m) throws RuntimeException {
		
		setNumero(numero);
		setData(data);
		setQuantidadeItens(quantidadeItens);
		setQuantidades(quantidades);
		setCliente(cliente, m);
		setProdutos(produtos, m);
	}
	
	public RegistroVenda(String stringRegVenda) throws RuntimeException{
		/*String info = numero do registro de venda, CPF do cliente, data da
		venda, codigo do produto 1, quantidade do produto 1, c´odigo do produto
		2, quantidade do produto 2, ..., código do produto n, quantidade do
		produto n, separado por ";" cada item*/
		
		try{
			int quantidadeItens = 0;
			String n[] = stringRegVenda.split(";");
			
			setNumero(Integer.parseInt(n[0]));
			/*obs: só com o cpf não eh possivel instanciar um cliente,
			 * é preciso ou indicar um obj Cliente ou o obj Mercado para a partir dele conseguir o obj Cliente*/
			
			setData(n[2]);
					
			quantidadeItens = (n.length-3)/2;
			setQuantidadeItens(quantidadeItens);
			
			for(int i = 3;i<n.length;i++){
				/*somente com o código do produto nao é possivel instanciar um produto
				 * é necessário indicar os objs produtos, ou o obj Mercado para a partir dele conseguir o objs Produtos
				 * */
			}			
		}catch(Exception e){throw new RuntimeException();}
	
	}

	public RegistroVenda(String stringRegVenda, Mercado m) throws RuntimeException{
		/*String info = numero do registro de venda, CPF do cliente, data da
		 *  venda, codigo do produto 1, quantidade do produto 1, c´odigo do produto
		 *  2, quantidade do produto 2, ..., código do produto n, quantidade do
	     *	produto n, separado por ";" cada item
		*/
		
		Cliente c;
		ArrayList<Produto> prods = new ArrayList<Produto>();
		ArrayList<Double>  qnts =  new ArrayList<Double>();
		int quantidadeItens = 0;
			
		String n[] = stringRegVenda.split(";");
		
		try{
			setNumero(Integer.parseInt(n[0]));
			
			c = m.getCliente(n[1]);
			setCliente(c);			
			
			setData(n[2]);
					
			quantidadeItens = (n.length-3)/2; /*da string tirando os tres primeiros dados sobram os dados sobre os produtos*/
			setQuantidadeItens(quantidadeItens);
			
			for(int i = 3;i<n.length;i=+2){
				prods.add(m.getProduto(Integer.parseInt(n[i])));
				qnts.add(Double.parseDouble(n[i+1]));
			}
			
			setQuantidades(qnts);
			setProdutos(prods);
			
		}catch(Exception e){throw new RuntimeException();}
	}

	public int getNumero()throws RuntimeException {
		return numero;
	}

	public void setNumero(int numero) throws RuntimeException{
		if(numero > 0)
			this.numero = numero;
		else
			throw new RuntimeException();
	}

	public Date getData()throws RuntimeException {
		return data;
	}

	public void setData(String data)throws RuntimeException {
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  		
	    df.setLenient (false); // aqui o pulo do gato  
	    try {
			this.data =  df.parse(data);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public int getQuantidadeItens() throws RuntimeException{
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens)throws RuntimeException {
		if (quantidadeItens > 0)
			this.quantidadeItens = quantidadeItens;
		else
			throw new RuntimeException();
	}

	public ArrayList<Double> getQuantidades() throws RuntimeException{
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

	public Cliente getCliente()throws RuntimeException {
		return cliente;
	}

	public void setCliente(Cliente cliente)throws RuntimeException {		
		this.cliente = cliente;
	}
	
	/*Este método verifica se o cliente pertence ao mercado*/
	public void setCliente(Cliente cliente, Mercado m)throws RuntimeException {		
		if(m.existeCliente(cliente.getCpf()))
			this.cliente = cliente;
		else
			throw new RuntimeException();
	}

	public ArrayList<Produto> getProdutos() throws RuntimeException{
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) throws RuntimeException {
		this.produtos = new ArrayList<Produto>();
		boolean prodOk = true;
				
		if(produtos.size() ==  quantidades.size()){
			for(int i=0; i< produtos.size();i++)
			{
				/* Se existe produto em estoque */
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
	
	/*Este método verifica alem de possuir produto em estoque ele também verifica se o produto pertence ao mercado*/
	public void setProdutos(ArrayList<Produto> produtos, Mercado m) throws RuntimeException {
		this.produtos = new ArrayList<Produto>();
		boolean prodOk = true;
				
		if(produtos.size() ==  quantidades.size()){
			for(int i=0; i< produtos.size();i++)
			{
				/* Se existe produto em estoque e se o produto existe no mercado (classe mercado)*/
				if(produtos.get(i).getEstoque() < quantidades.get(i) &&
						m.existeProduto(produtos.get(i).getCodigo())){
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
	
	private void atualizaEstoque(ArrayList<Produto> produtos)throws RuntimeException{
		for(int i=0; i< produtos.size();i++){
			Produto p = produtos.get(i);
			p.setEstoque(p.getEstoque()-quantidades.get(i));
			produtos.set(i, p);
		}
		
	}
	
	/*funcao que calcula o valor total da compra*/
	public double valorTotalCompra()throws RuntimeException	{
		double fat = 0.0;
		for(int i =0;i<quantidadeItens;i++){
			fat += produtos.get(i).getPrecoVenda()*quantidades.get(i);			
		}
		return fat;
	}
	
}
