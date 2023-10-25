import java.util.Iterator;

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
		if(this.getClass() == u2.getClass()) {
			throw new RuntimeException("no se puede pelear contra su mismo tipo, deben ser enemigos");
		}
		double aux = enfrentar(u2, c);
		if (aux > 0)
			return true;

		return false;

	}

	public double gana(double d, double e) {
		return d - e;
	}

	protected double enfrentar(Competidor u2, Caracteristica c) {
			int i=0;
			double aux=0;
			while (c.name()!=vector[i]) {
				i++;	
			}
			for (int j = i+1;j<i+4;j++) {
				if(j==1||j==5)
					aux = gana(this.getVelocidad(), u2.getVelocidad());
				if(j==2||j==6)
					aux = gana(this.getFuerza(), u2.getFuerza());
				if(j==3||j==7)
					aux = gana(this.getResistencia(), u2.getResistencia());
				if(j==4)
					aux = gana(this.getDestreza(), u2.getDestreza());
				if(aux!=0)
					return aux;
			}
			return 0;
	
	}
/*
//		double aux = 0;
//		if (a < 4) {
//			if (Caracteristica.toUpperCase() == "FUERZA") {
//				aux = gana(this.getFuerza(), u2.getFuerza());
//				if (aux != 0)
//					return aux;
//				return enfrentar(u2, "RESISTENCIA", a + 1);
//			}
//
//			if (Caracteristica.toUpperCase() == "RESISTENCIA") {
//				aux = gana(this.getResistencia(), u2.getResistencia());
//				if (aux != 0)
//					return aux;
//
//				return enfrentar(u2, "DESTREZA", a + 1);
//			}
//
//			if (Caracteristica.toUpperCase() == "DESTREZA") {
//				aux = gana(this.getDestreza(), u2.getDestreza());
//				if (aux != 0)
//					return aux;
//
//				return enfrentar(u2, "VELOCIDAD", a + 1);
//			}
//			if (Caracteristica.toUpperCase() == "VELOCIDAD") {
//				aux = gana(this.getVelocidad(), u2.getVelocidad());
//				if (aux != 0)
//					return aux;
//				return enfrentar(u2, "FUERZA", a + 1);
//			}
//
//			System.out.println("Caracteristica incompatible");
//		}
//		return 0;
//
//	}
*/
}
