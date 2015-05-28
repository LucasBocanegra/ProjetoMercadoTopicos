package br.com.starcode.logic;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	
	private final int Ativo = 1;
	private final int Inativo = 0;

	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private int status;
	
	public Cliente(String nome, String cpf, String endereco, String telefone,
			String email, int status) {
	
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setTelefone(telefone);
		setEmail(email);
		setStatus(status);
	}
	
	public void alteraCliente(String nome, String cpf, String endereco, String telefone,
			String email, int status) {
		
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setTelefone(telefone);
		setEmail(email);
		setStatus(status);		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)throws RuntimeException {
		String n[] = new String[2];
		if(nome.length() >= 5 && nome.length() <= 128){
			//particiona o nome em prenome e sobrenome
			n = nome.split(" ");
			//se existir o segundo nome e tiver 2 letras no min
			if(!n[2].isEmpty() && n[2].length() == 2){
				this.nome = nome;
			}else
				throw new RuntimeException();			
		}else
			throw new RuntimeException();
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws RuntimeException{
		if(isCPF(cpf))
			this.cpf = cpf;
		else
			throw new RuntimeException();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws RuntimeException{
		if(endereco.length() <= 256)		
			this.endereco = endereco;
		else
			throw new RuntimeException();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws RuntimeException {
		Pattern pattern = Pattern.compile("(\\d{2})\\d{9}");
	    Matcher matcher = pattern.matcher(telefone);
	     
		if(matcher.matches()){			
			this.telefone = telefone;
		}else
			throw new RuntimeException();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws RuntimeException {
		String n[] = new String[2];
		String d[] = new String[3];
		
 		n = email.split("@"); //separa usuario e dominio	
 		d = n[1].split("."); // separa dominio e complemento
 		
 		Character l1 = n[0].toCharArray()[0]; //primeiro caracter do usu�rio
 		Character l2 = n[1].toCharArray()[0]; //primeira caracter do dominio
 		
 		if(Character.isLetter(l1) && Character.isLetter(l2))
 		{
 			if((d[1].equalsIgnoreCase("com") && d[2].isEmpty())
 					|| (d[1].equalsIgnoreCase("com") && d[2].equalsIgnoreCase("br")))
 			{
 				this.email = email;
 				
 			}else
 				throw new RuntimeException();
 		}else
 			throw new RuntimeException();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status)throws RuntimeException {
		
		if(status == Ativo || status == Inativo)
			this.status = status;
		else
			throw new RuntimeException();
	}
	
	private boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int)(CPF.charAt(i) - 48);  
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true);
			else return(false);
			
		} catch (InputMismatchException erro) {
			return(false);
		}
	}
	
}