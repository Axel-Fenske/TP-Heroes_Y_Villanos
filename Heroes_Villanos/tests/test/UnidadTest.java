package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Unidad;

public class UnidadTest {

	Unidad u, u2;

	@Before
	public void setUp() {
		u = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		u2 = new Unidad("villano", "Ben Solo", "Ben Solo", 200, 200, 200, 200);
	}

	@Test
	public void compararPorVelocidad() {
		assertEquals(-180, u.compareTo(u2, Caracteristica.VELOCIDAD), 0.01);
	}

	@Test
	public void compararPorFuerza() {
		assertEquals(100, u.compareTo(u2, Caracteristica.FUERZA), 0.01);
	}

	@Test
	public void compararPorResistencia() {
		assertEquals(300, u.compareTo(u2, Caracteristica.RESISTENCIA), 0.01);
	}

	@Test
	public void compararPorDestreza() {
		assertEquals(-180, u.compareTo(u2, Caracteristica.DESTREZA), 0.01);
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
