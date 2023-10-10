
public abstract class Unidad {

	private String nombre;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

	Unidad(String nombre, int velocidad, int fuerza, int resistencia, int destreza) {

		this.nombre = nombre;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}


	public Object enfrentar(Unidad a1) {
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

	public String getNombre() {
		return this.nombre;
	}
	
}

