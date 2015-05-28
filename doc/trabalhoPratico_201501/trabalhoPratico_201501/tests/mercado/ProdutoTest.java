/**
 * 
 */
package mercado;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ferrari
 *
 */
public class ProdutoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	// testa Produto qualquer
	@Test
	public void testProduto_c1() {
		try {
			Produto c1 = new Produto(1, "farinha", 1.50, 1.80, "KG", 100.0, 1 );					 
		}
		catch (RuntimeException e) {
			// este bloco pode ser usado para garantir que um 
			// produto válido não lança uma exceção
			// (também pode ser usado com a estratégia oposta)
			fail();
		}
	}	

}
