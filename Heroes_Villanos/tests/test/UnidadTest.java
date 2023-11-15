package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Unidad;

public class UnidadTest {
	
	Unidad u;
	
	@Before
	public void setUp() {
		u = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
	}

	@Test
	public void testGetVelocidad() {
		assertEquals(20, u.getCaracteristica(Caracteristica.VELOCIDAD), 0.01);
	}
	
	@Test
	public void testGetFuerza() {
		assertEquals(300, u.getCaracteristica(Caracteristica.FUERZA), 0.01);
	}
	
	@Test
	public void testGetResistencia() {
		assertEquals(500, u.getCaracteristica(Caracteristica.RESISTENCIA), 0.01);
	}
	
	@Test
	public void testGetDestreza() {
		assertEquals(200, u.getCaracteristica(Caracteristica.DESTREZA), 0.01);
	}

}
