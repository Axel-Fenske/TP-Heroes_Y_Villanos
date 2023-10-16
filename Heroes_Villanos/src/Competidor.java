
public abstract class Competidor {
	private String tipo;
	private String nombreReal;
	private String nombrePersonaje;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

	public int gana(int a, int b) {
		return a - b;
	}

	private int enfrentar(Competidor u2, String Caracteristica, int a) {
		int aux = 0;
		if (a < 4) {
			if (Caracteristica.toUpperCase() == "FUERZA") {
				aux = gana(this.fuerza, u2.fuerza);
				if (aux != 0)
					return aux;
				return enfrentar(u2, "RESISTENCIA", a + 1);
			}

			if (Caracteristica.toUpperCase() == "RESISTENCIA") {
				aux = gana(this.resistencia, u2.resistencia);
				if (aux != 0)
					return aux;

				return enfrentar(u2, "DESTREZA", a + 1);
			}

			if (Caracteristica.toUpperCase() == "DESTREZA") {
				aux = gana(this.destreza, u2.destreza);
				if (aux != 0)
					return aux;

				return enfrentar(u2, "VELOCIDAD", a + 1);
			}
			if (Caracteristica.toUpperCase() == "VELOCIDAD") {
				aux = gana(this.velocidad, u2.velocidad);
				if (aux != 0)
					return aux;
				return enfrentar(u2, "FUERZA", a + 1);
			}

			System.out.println("Caracteristica incompatible");
		}
		return 0;

	}
}
