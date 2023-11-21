package test;

import static org.junit.Assert.*;

import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Competidor;
import heroes_villanos.Liga;
import heroes_villanos.Unidad;

public class EnfrentamientosTest {

	@Test
	public void testUnidadVSLiga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);

		Liga l1 = new Liga("villano", "liga");

		l1.agregar(u1);
		l1.agregar(u2);

		Competidor u3 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);

		assertTrue(u3.esGanador(l1, Caracteristica.FUERZA));
	}

	@Test
	public void testLigaVSLiga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);

		Liga l1 = new Liga("Villano", "villanos");

		l1.agregar(u1);
		l1.agregar(u2);

		Competidor u3 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 200, 400, 100);
		Competidor u4 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);

		Liga l2 = new Liga("heroe", "heroes");

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

		Liga l1 = new Liga("Villano", "villanos");

		Liga l3 = new Liga("villano", "subliga");

		l1.agregar(u1);
		l1.agregar(u2);

		l3.agregar(u3);
		l3.agregar(u4);

		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 300, 200, 400, 100);
		Competidor u6 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);

		Liga l2 = new Liga("heroe", "heroes");

		l2.agregar(u5);
		l2.agregar(u6);

		assertFalse(l2.esGanador(l1, Caracteristica.DESTREZA));
	}

	@Test
	public void testEmpateLigaVSLigaConSubliga() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 201, 300);

		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 100);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 10, 100);

		Liga l1 = new Liga("Villano", "villanos");

		Liga l3 = new Liga("Villano", "subliga");

		l1.agregar(u1);
		l1.agregar(u2);

		l3.agregar(u3);
		l3.agregar(u4);

		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 200, 200, 200, 0);
		Competidor u6 = new Unidad("heroe", "Hakerman", "Virus", 20, 200, 304, 400);

		Liga l2 = new Liga("heroe", "heroes");

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

		Liga l1 = new Liga("Villano", "villanos");

		Liga l3 = new Liga("Villano", "subliga");

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
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 30, 300, 500, 600);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 100, 300);

		Competidor u3 = new Unidad("villano", "Edward Nygma", "Acertijo", 100, 100, 100, 500);
		Competidor u4 = new Unidad("villano", "Ridder", "Voldemort", 500, 200, 20, 100);

		Liga l1 = new Liga("Villano", "villanos");

		Liga l3 = new Liga("Villano", "subliga");

		l1.agregar(u1);
		l1.agregar(u2);

		l3.agregar(u3);
		l3.agregar(u4);

		l1.agregar(l3);

		Competidor u5 = new Unidad("heroe", "Bruce Waine", "Batman", 110, 200, 220, 400);
		assertTrue(!l1.esGanador(u5, Caracteristica.RESISTENCIA) && !u5.esGanador(l1, Caracteristica.RESISTENCIA));
	}

}
