package test;

import static org.junit.Assert.*;

import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Competidor;
import heroes_villanos.LigaHeroes;
import heroes_villanos.LigaVillanos;
import heroes_villanos.Unidad;

public class EnfrentamientosTest {

	@Test
	public void testUnidadVSLiga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		LigaVillanos l1 = new LigaVillanos("liga");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		Competidor u3 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);
		
		assertTrue(u3.esGanador(l1, Caracteristica.FUERZA));
	}
	
	@Test
	public void testLigaVSLiga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		LigaVillanos l1 = new LigaVillanos("villanos");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		Competidor u3 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 200, 400, 100);
		Competidor u4 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);
		
		LigaHeroes l2 = new LigaHeroes("heroes");
		
		l2.agregar(u3);
		l2.agregar(u4);
		
		assertTrue(l2.esGanador(l1, Caracteristica.VELOCIDAD));
	}
	
	@Test
	public void testLigaVSLigaConSubliga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		LigaVillanos l1 = new LigaVillanos("villanos");
		
		LigaVillanos l3 = new LigaVillanos("subliga");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		l3.agregar(u3);
		l3.agregar(u4);
		
		l1.agregar(l3);
				
		
		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 200, 400, 100);
		Competidor u6 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);
		
		LigaHeroes l2 = new LigaHeroes("heroes");
		
		l2.agregar(u5);
		l2.agregar(u6);
		
		assertFalse(l2.esGanador(l1, Caracteristica.DESTREZA));
	}
	
	@Test
	public void testEmpateLigaVSLigaConSubliga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		LigaVillanos l1 = new LigaVillanos("villanos");
		
		LigaVillanos l3 = new LigaVillanos("subliga");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		l3.agregar(u3);
		l3.agregar(u4);
		
		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 175, 200, 150);
		Competidor u6 = new Unidad("heroe", "Hakerman", "Virus", 15, 200, 205, 200);
		
		LigaHeroes l2 = new LigaHeroes("heroes");
		
		l2.agregar(u5);
		l2.agregar(u6);
		
		assertTrue(!l2.esGanador(l1, Caracteristica.VELOCIDAD) && !l1.esGanador(l2, Caracteristica.VELOCIDAD));
	}
	
	@Test
	public void testLigaConSubligaVSUnidad() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		LigaVillanos l1 = new LigaVillanos("villanos");
		
		LigaVillanos l3 = new LigaVillanos("subliga");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		l3.agregar(u3);
		l3.agregar(u4);
		
		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 175, 200, 150);
		
		assertTrue(l1.esGanador(u5, Caracteristica.RESISTENCIA));
	}
	
	@Test
	public void testEmpateLigaConSubligaVSUnidad() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);
		
		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);
		
		LigaVillanos l1 = new LigaVillanos("villanos");
		
		LigaVillanos l3 = new LigaVillanos("subliga");
		
		l1.agregar(u1);
		l1.agregar(u2);
		
		l3.agregar(u3);
		l3.agregar(u4);
		
		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 157.5, 187.5, 202.5, 175);
		
		assertTrue(!l1.esGanador(u5, Caracteristica.RESISTENCIA) && !u5.esGanador(l1, Caracteristica.RESISTENCIA));
	}

}
