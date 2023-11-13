package heroes_villanos;


public class Unidad extends Competidor {
	private boolean perteneceAUnaLiga=false;
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

	public Unidad(String tipo, String nombreReal, String nombrePersonaje, double velocidad,
			double fuerza, double resistencia,double destreza) {
		confirmarTipo(tipo);
		this.nombreReal = nombreReal;
		this.nombre = nombrePersonaje;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getResistencia() {
		return resistencia;
	}

	public double getDestreza() {
		return destreza;
	}

	public double getFuerza() {
		return fuerza;
	}

	public boolean isPerteneceAUnaLiga() {
		return perteneceAUnaLiga;
	}

	public void setPerteneceAUnaLiga() {
		this.perteneceAUnaLiga = true;
	}
	@Override
	public String toString() {
		return tipo + ", " + nombreReal + ", " + nombre
				+ ", " + velocidad + ", " + fuerza + ", "
				+ resistencia + ", " + destreza;
	}

}
