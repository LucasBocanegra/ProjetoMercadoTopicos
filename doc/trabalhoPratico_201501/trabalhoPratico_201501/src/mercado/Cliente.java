/**
 * 
 */
package mercado;

/**
 * @author ferrari
 *
 */
public class Cliente {

	private String nome;
	private String CPF;
	private String endereco;
	private String telefone;
	private String email;
	private int status;

	// implementacao basica, sem validacoes
	public Cliente(String nome, String CPF, String endereco, 
			String telefone, String email, int status) {
		try {
			this.nome = nome;
			this.CPF = CPF;
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
			this.status = status;
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	// implementacao basica, sem validacoes
	public void alteraCliente(String nome, String CPF, String endereco, 
			String telefone, String email, int status) {
		try {
			this.nome = nome;
			this.CPF = CPF;
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
			this.status = status;
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



}
