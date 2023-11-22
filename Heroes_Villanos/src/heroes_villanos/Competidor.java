package heroes_villanos;

public abstract class Competidor {
	protected String tipo;
	protected String nombre;
	static final String[] vector = { "VELOCIDAD", "FUERZA", "RESISTENCIA", "DESTREZA", "VELOCIDAD", "FUERZA",
			"RESISTENCIA" };

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract double getCaracteristica(Caracteristica c);

	public boolean esGanador(Competidor u2, Caracteristica c) {
		if (this == u2)
			throw new RuntimeException("no se puede pelear con si mismo");
		if (this.tipo.equals(u2.tipo)) {
			throw new RuntimeException("no se puede pelear contra su mismo tipo, deben ser enemigos");
		}
		
		return this.compareTo(u2, c) > 0;
	}

	public double compareTo(Competidor o, Caracteristica car) {

		int i = 0, j;
		double cmp = 0;
		while (car.name() != (vector[i]))
			i++;

		for (j = i; j < i + 4; j++) {
			Caracteristica c = Caracteristica.valueOf(vector[j]);
			cmp = this.getCaracteristica(c) - o.getCaracteristica(c);
			if (cmp != 0)
				return cmp;
		}

		return cmp;
	}

}
