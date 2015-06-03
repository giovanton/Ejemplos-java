package ejemploRepaso.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import ejemploRepaso.exceptions.InsertarPersonaException;
import ejemploRepaso.exceptions.PersonaNoEncontradaException;

public class TestListaPersona {
	static ListaPersonas lp;
	static ejemploRepaso.base.Persona p1;
	static ejemploRepaso.base.Persona p2;
	static ejemploRepaso.base.Persona p3;
	static ejemploRepaso.base.Persona p4;
	static ejemploRepaso.base.Persona p5;

	@BeforeClass
	public static void inicioTest() throws InsertarPersonaException,
			PersonaNoEncontradaException {
		lp = new ListaPersonas();
		p1 = new ejemploRepaso.base.Persona("carlos", 32);
		p2 = new ejemploRepaso.base.Persona("juan", 35);
		p3 = new ejemploRepaso.base.Persona("marta", 22);
		p4 = new ejemploRepaso.base.Persona("carlota", 32);
		p5 = new ejemploRepaso.base.Persona("sonia", 23);

		lp.insertarPersona(p1);
		lp.insertarPersona(p2);
		lp.insertarPersona(p3);
		lp.insertarPersona(p4);
	}

	@Test
	public void testBuscarPersonaString() throws PersonaNoEncontradaException {
		assertEquals(p1, lp.buscarPersona("carlos"));
	}

	@Test
	public void testBuscarPersonaInt() {
		assertEquals(p1, lp.buscarPersona(32));
	}

	@Test
	public void testInsertarPersona() throws PersonaNoEncontradaException,
			InsertarPersonaException {
		lp.insertarPersona(p5);
		assertNotNull(lp.buscarPersona("sonia"));
	}

	@Test
	public void testEstaLlena() throws InsertarPersonaException,
			PersonaNoEncontradaException {
		lp.insertarPersona(p5);
		lp.insertarPersona(p5);
		lp.insertarPersona(p5);
		lp.insertarPersona(p5);
		lp.insertarPersona(p5);
		assertTrue(lp.estaLlena());
	}

	@Test
	public void testSerializar() throws IOException {
		lp.serializar();
		assertThat(p1, new EsSerializado());
	}

}
