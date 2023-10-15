
public  class Competidor {

	private String heroe_o_villano;
	private String nombreReal;
	private String nombrePersonaje;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;




	public Competidor(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
			int resistencia, int destreza) {
		this.heroe_o_villano = heroe_o_villano;
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}


	
	public String getHeroe_o_villano() {
		return heroe_o_villano;
	}


	public String getNombreReal() {
		return nombreReal;
	}


	public String getNombrePersonaje() {
		return nombrePersonaje;
	}


	public int getVelocidad() {
		return velocidad;
	}

	
	public int getFuerza() {
		return fuerza;
	}


	public int getResistencia() {
		return resistencia;
	}

	
	public int getDestreza() {
		return destreza;
	}

	

	public Object enfrentar(Competidor a1) {
		if (this.velocidad > a1.velocidad) {
			return this;
		}
		if (this.velocidad < a1.velocidad) {
			return a1;
		}

		// Si la velocidad es igual, comparamos por fuerza
		if (this.fuerza > a1.fuerza) {
			return this;
		}
		if (this.fuerza < a1.fuerza) {
			return a1;
		}

		// Si la fuerza también es igual, comparamos por resistencia
		if (this.resistencia > a1.resistencia) {
			return this;
		}
		if (this.resistencia < a1.resistencia) {
			return a1;
		}

		// Si la resistencia también es igual, comparamos por destreza
		if (this.destreza > a1.destreza) {
			return this;
		}
		if (this.destreza < a1.destreza) {
			return a1;
		}

		// Si todas las características son iguales, es un empate
		return null;
	}


	
}

