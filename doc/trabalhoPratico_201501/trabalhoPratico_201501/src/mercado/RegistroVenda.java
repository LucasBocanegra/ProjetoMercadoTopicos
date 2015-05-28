/**
 * 
 */
package mercado;

import java.util.Date;

/**
 * @author ferrari
 *
 */
public class RegistroVenda {

	private int numero;
	private Date data;
	private int quantidadeItens;
	private double[] quantidades = new double[100];
	private Cliente cliente;
	private Produto [] produtos = new Produto[100];


	// implementacao basica, sem validacoes
	public RegistroVenda(String stringRegistroVenda) {
		try {

		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
