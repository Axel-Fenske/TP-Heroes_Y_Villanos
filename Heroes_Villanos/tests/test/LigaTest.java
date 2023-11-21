package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Liga;
import heroes_villanos.Unidad;

public class LigaTest {
	
	Liga liga;
	
	@Before
	public void setUp() {
		
		liga = new Liga("Villano","superliga");
		
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Unidad u2 = new Unidad("villano", "J.R.R.Tolkien", "Sauron", 0, 150, 200, 300);
		Unidad u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Unidad u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		Liga liga2 = new Liga("Villano","subliga");
		
		liga2.agregar(u3);
		liga2.agregar(u4);
		
		liga.agregar(u1);
		liga.agregar(u2);
		liga.agregar(liga2);
		
	}

	@Test
	public void testGetVelocidad() {
		assertEquals((20.0+0+(100+500)/2)/3, liga.getCaracteristica(Caracteristica.VELOCIDAD), 0.01);
	}
	
	@Test
	public void testGetFuerza() {
		assertEquals((300.0+150+(100+200)/2)/3, liga.getCaracteristica(Caracteristica.FUERZA), 0.01);
	}
	
	@Test
	public void testGetResistencia() {
		assertEquals((500.0+200+(100+10)/2)/3, liga.getCaracteristica(Caracteristica.RESISTENCIA), 0.01);
	}
	
	@Test
	public void testGetDestreza() {
		assertEquals((200+300+(100+100)/2)/3, liga.getCaracteristica(Caracteristica.DESTREZA), 0.01);
	}

	@Test
	public void testExisteEnEstaLiga() {
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		
		assertTrue(Liga.existeEnEstaLiga(liga, u1));
	}
	
	
	@Test
	public void testAgregarDistintoTipo() {
		Unidad u = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);
		
		assertFalse(liga.agregar(u));
		
	}
	@Test
	public void testAgregarDosVecesAUnaLiga_SubLiga() {
		Unidad u2 = new Unidad("villano", "J.R.R.Tolkien", "Sauron", 0, 150, 200, 300);
		
		assertFalse(liga.agregar(u2));
		
	}
	
	@Test 
	public void noConfundeUnidadYLigaConElMismoNombre() {
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "villano", 20, 300, 500, 200);
		Liga liga1 = new Liga("Villano","liga1");
		Liga liga3 = new Liga("Villano","villano");
		liga1.agregar(liga3);
		assertFalse(Liga.existeEnEstaLiga(liga1,u1));
	}
}
