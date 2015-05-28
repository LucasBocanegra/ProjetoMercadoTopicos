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
public class RegistroVendaTest {

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

	// testa RegistroVenda qualquer
	@Test
	public void testRegistroVenda_c1() {
		try {
			RegistroVenda r1 = new RegistroVenda("abc");						 
		}
		catch (RuntimeException e) {
			// este bloco pode ser usado para garantir que um 
			// registro de venda válido não lança uma exceção
			// (também pode ser usado com a estratégia oposta)
			fail();
		}
	}
}
