package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heroes_villanos.Liga;
import heroes_villanos.LigaVillanos;
import heroes_villanos.Unidad;

public class LigaTest {
	
	Liga liga;
	
	@Before
	public void setUp() {
		
		liga = new LigaVillanos("superliga");
		
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Unidad u2 = new Unidad("villano", "J.R.R.Tolkien", "Sauron", 0, 150, 200, 300);
		Unidad u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Unidad u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		Liga liga2 = new LigaVillanos("subliga");
		
		liga2.agregar(u3);
		liga2.agregar(u4);
		
		liga.agregar(u1);
		liga.agregar(u2);
		liga.agregar(liga2);
		
	}

	@Test
	public void testGetVelocidad() {
		assertEquals(155, liga.getVelocidad(), 0.01);
	}
	
	@Test
	public void testGetFuerza() {
		assertEquals(187.5, liga.getFuerza(), 0.01);
	}
	
	@Test
	public void testGetResistencia() {
		assertEquals(202.5, liga.getResistencia(), 0.01);
	}
	
	@Test
	public void testGetDestreza() {
		assertEquals(175, liga.getDestreza(), 0.01);
	}

	@Test
	public void testExisteEnEstaLiga() {
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		
		assertTrue(Liga.extisteEnEstaLiga(liga, u1));
	}
	
	@Test
	public void testEliminar() {
		Unidad u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Unidad u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		LigaVillanos liga2 = new LigaVillanos("subliga");
		
		liga2.agregar(u3);
		liga2.agregar(u4);
		
		liga2.eliminarVillano(u4);
		
		assertFalse(Liga.extisteEnEstaLiga(liga2, u4));
		
	}
	
	@Test
	public void testAgregarDistintoTipo() {
		Unidad u = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);
		
		assertFalse(liga.agregar(u));
		
	}

}
