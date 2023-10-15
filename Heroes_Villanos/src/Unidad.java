
public abstract class Unidad {

	private String nombre;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;
	private int a = 0;
	private String Tipo;
	

	Unidad(String nombre, int velocidad, int fuerza, int resistencia, int destreza) {

		this.nombre = nombre;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}

	public boolean esGanador(Unidad u2, String caracteristica) {
		if (this == u2)
			throw new RuntimeException("no se puede pelear con si mismo");
		int aux = enfrentar2(u2, caracteristica, 0);
		if (aux > 0)
			return true;

		return false;

	}

	public int gana(int a, int b) {
		return a - b;
	}

	public int enfrentar2(Unidad u2, String Caracteristica, int a) {
		int aux = 0;
		while (a < 4) {
			if (Caracteristica == "Fuerza") {
				aux = gana(this.fuerza, u2.fuerza);
				if (aux != 0)
					return aux;

				return enfrentar2(u2, "resistencia", a + 1);
			}

			if (Caracteristica == "resistencia") {
				aux = gana(this.resistencia, u2.resistencia);
				if (aux != 0)
					return aux;

				return enfrentar2(u2, "destreza", a + 1);
			}

			if (Caracteristica == "destreza") {
				aux = gana(this.destreza, u2.destreza);
				if (aux != 0)
					return aux;

				return enfrentar2(u2, "velocidad", a + 1);
			}
			if (Caracteristica == "velocidad") {
				aux = gana(this.velocidad, u2.velocidad);
				if (aux != 0)
					return aux;

				return enfrentar2(u2, "fuerza", a + 1);
			}
		}
		return 0;

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
