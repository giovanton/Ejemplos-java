package persona;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPersona {

	@Test
	public void testPersona() {
		Persona p = new Persona("carlos",32);
		assertNotNull(p);
	}

	@Test
	public void testGetEdad() {
		Persona p = new Persona("carlos",32);
		assertEquals(32, p.getEdad());
	}

	@Test
	public void testSetEdad() {
		Persona p = new Persona("carlos",32);
		p.setEdad(35);
		assertTrue(p.getEdad() == 35);;
	}

	@Test
	public void testGetNombre() {
		Persona p = new Persona("carlos",32);
		assertEquals("carlos", p.getNombre());
	}

	@Test
	public void testSetNombre() {
		Persona p = new Persona("carlos",32);
		p.setNombre("juan");
		assertEquals("juan", p.getNombre());
	}

	@Test
	public void testToString() {
		Persona p = new Persona("carlos",32);
		assertEquals("carlos 32", p.toString());
	}
	
	@Test
	public void testCompareTo() {
		Persona p1 = new Persona("carlos",32);
		Persona p2 = new Persona("carlos",32);
		assertTrue(p1.compareTo(p2) == 0);
	}


}
