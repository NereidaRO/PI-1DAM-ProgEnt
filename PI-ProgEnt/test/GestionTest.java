/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import PI_Gestion.*;

/**
 *
 * @author Asus
 */
public class GestionTest {
    
   /**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
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
