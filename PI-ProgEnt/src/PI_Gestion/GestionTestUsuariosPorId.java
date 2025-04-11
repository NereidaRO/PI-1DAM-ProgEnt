/**
 * 
 */
package PI_Gestion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 */
public class GestionTestUsuariosPorId {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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

	/**
	 * Test method for {@link PI_Gestion.Gestion#buscarUsuarioPorId(int)}.
	 */
	@Test
	public void testBuscarUsuarioPorId() {
		
		Gestion instancia = new Gestion();
		int Id = 5;
		int resultado;
		int resultadosExp = 3;
		resultado = instancia.buscarUsuarioPorId(Id);
		assertEquals(resultado, resultadosExp);
		
	}

}
