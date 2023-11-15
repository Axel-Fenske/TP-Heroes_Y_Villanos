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

	@Override
	public double getCaracteristica(Caracteristica c) {
		if(c==Caracteristica.VELOCIDAD) {
			return velocidad;
		}
		else if(c==Caracteristica.RESISTENCIA){
			return resistencia;
		}
		else if(c==Caracteristica.DESTREZA){
			return destreza;
		}
		else if(c==Caracteristica.FUERZA){
			return fuerza;
		}
		else {
			throw new RuntimeException("Caracteristica Invalida");
		}
	}

}
