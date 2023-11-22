package heroes_villanos;

public class Unidad extends Competidor {
	private String nombreReal;
	private double velocidad;
	private double fuerza;
	private double resistencia;
	private double destreza;

	private void confirmarTipo(String t) {
		String tipo = t.toLowerCase();
		if (tipo.compareTo("villano") != 0 && tipo.compareTo("heroe") != 0)
			throw new RuntimeException("el tipo debe ser heroe o villano");
		this.tipo = tipo;
	}

	public Unidad(String tipo, String nombreReal, String nombrePersonaje, double velocidad, double fuerza,
			double resistencia, double destreza) {
		confirmarTipo(tipo);
		this.nombreReal = nombreReal;
		this.nombre = nombrePersonaje;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}

	@Override
	public String toString() {
		return tipo + ", " + nombreReal + ", " + nombre + ", " + velocidad + ", " + fuerza + ", " + resistencia + ", "
				+ destreza;
	}

	@Override
	public double getCaracteristica(Caracteristica c) {
		double[] vec = { velocidad, fuerza, resistencia, destreza };
		return vec[c.ordinal()];
	}

}