package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heroes_villanos.Unidad;

public class UnidadTest {
	
	Unidad u;
	
	@Before
	public void setUp() {
		u = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
	}

	@Test
	public void testGetVelocidad() {
		assertEquals(20, u.getVelocidad(), 0.01);
	}
	
	@Test
	public void testGetFuerza() {
		assertEquals(300, u.getFuerza(), 0.01);
	}
	
	@Test
	public void testGetResistencia() {
		assertEquals(500, u.getResistencia(), 0.01);
	}
	
	@Test
	public void testGetDestreza() {
		assertEquals(200, u.getDestreza(), 0.01);
	}

}
