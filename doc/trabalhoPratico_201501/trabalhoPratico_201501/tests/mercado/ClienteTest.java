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
public class ClienteTest {

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

	
	// testa Cliente qualquer
	@Test
	public void testCliente_c1() {
		try {
			Cliente c1 = new Cliente(
					"Fabiano Ferrari",
					"1234",
					"Rod Washington Luis, km 235, Sao Carlos, SP",
					"(16) 3306-6605",
					"fabiano@dc.ufscar.br",
					1);					 
		}
		catch (RuntimeException e) {
			// este bloco pode ser usado para garantir que um 
			// cliente válido não lança uma exceção
			// (também pode ser usado com a estratégia oposta)
			fail();
		}
	}

}
