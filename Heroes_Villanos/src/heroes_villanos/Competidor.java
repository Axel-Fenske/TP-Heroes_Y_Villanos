package heroes_villanos;
public abstract class Competidor {
	protected String tipo;
	protected String nombre;
	static final String[] vector= {
			"VELOCIDAD","FUERZA","RESISTENCIA","DESTREZA","VELOCIDAD","FUERZA","RESISTENCIA"
	};
	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract double getVelocidad();

	public abstract double getFuerza();

	public abstract double getResistencia();

	public abstract double getDestreza();

	public boolean esGanador(Competidor u2, Caracteristica c) {
		if (this == u2)
			throw new RuntimeException("no se puede pelear con si mismo");
		if(this.tipo.equals(u2.tipo)) {
			throw new RuntimeException("no se puede pelear contra su mismo tipo, deben ser enemigos");
		}
		double aux = this.compareTo(u2, c);
		System.out.println(aux);
		if (aux > 0)
			return true;

		return false;

	}

	public double compareTo(Competidor o,Caracteristica car) {
		String caract[] = { "FUERZA", "VELOCIDAD", "DESTREZA", "RESISTENCIA", "FUERZA", "VELOCIDAD", "DESTREZA" };
		int i = 0, j;
		double cmp = 0;
		
		while (car.name() != (caract[i]))
			i++;
		
		for (j = i; j < i + 4; j++) {
			
			if (caract[j].compareTo(Caracteristica.DESTREZA.name()) == 0) {
				 cmp = this.getDestreza() - o.getDestreza();
				 if(cmp != 0)
					 return cmp;
			}
			if (caract[j].compareTo(Caracteristica.FUERZA.name()) == 0) {
				cmp = this.getFuerza() - o.getFuerza();
				 if(cmp != 0)
					 return cmp;
			}
			if (caract[j].compareTo(Caracteristica.RESISTENCIA.name()) == 0) {
				cmp = this.getResistencia() - o.getResistencia();
				 if(cmp != 0)
					 return cmp;
			}
			if (caract[j].compareTo(Caracteristica.VELOCIDAD.name()) == 0) {
				cmp = this.getVelocidad() - o.getVelocidad();
				 if(cmp != 0)
					 return cmp;
			}
			
		}
	
		return cmp;
	}
	
}
