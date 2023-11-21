package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import heroes_villanos.Caracteristica;
import heroes_villanos.Unidad;
import heroes_villanos.Competidor;

public class CompetidorTest {

	@Test
	public void esGanadorTestVelocidad() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);

		assertTrue(u1.esGanador(u2, Caracteristica.VELOCIDAD));
	}

	@Test
	public void esGanadorTestFuerza() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);

		assertTrue(u1.esGanador(u2, Caracteristica.FUERZA));
	}

	@Test
	public void esGanadorTestResistencia() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);

		assertFalse(u1.esGanador(u2, Caracteristica.RESISTENCIA));
	}

	@Test
	public void esGanadorTestDestreza() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 300);

		assertFalse(u1.esGanador(u2, Caracteristica.DESTREZA));
	}

	@Test
	public void esGanadorTestEmpateDestreza() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", -100, 0, 100000, 200);

		assertTrue(u1.esGanador(u2, Caracteristica.DESTREZA));
	}

	@Test
	public void esGanadorTestEmpate() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("heroe", "Hakerman", "Virus", 20, 300, 500, 200);

		assertTrue(!u1.esGanador(u2, Caracteristica.VELOCIDAD) && !u2.esGanador(u1, Caracteristica.VELOCIDAD));
	}

	@Test(expected = RuntimeException.class)
	public void esGanadorTestPeleaConsigoMismo() {
		Unidad u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);

		u1.esGanador(u1, Caracteristica.FUERZA);
	}

	@Test(expected = RuntimeException.class)
	public void esGanadorTestPeleaConMismoTipo() {
		Competidor u1 = new Unidad("villano", "Anakin Skywalker", "Darth Vader", 20, 300, 500, 200);
		Competidor u2 = new Unidad("villano", "J. R. R. Tolkien", "Sauron", 0, 150, 200, 300);

		u1.esGanador(u2, Caracteristica.FUERZA);
	}

}
