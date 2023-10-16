
public abstract class Bando {

	
	
	
	
	
	public abstract double getFuerza();
	public abstract double getVelocidad();
	public abstract double getResistencia();
	public abstract double getDestreza();

	
	
	public boolean esGanador(Bando u2, String caracteristica) {
		if (this == u2)
			throw new RuntimeException("no se puede pelear con si mismo");
		int aux = enfrentar(u2, caracteristica, 0);
		if (aux > 0)
			return true;

		return false;

	}

	public int gana(int a, int b) {
		return a - b;
	}
	
	private int enfrentar(Bando u2, String Caracteristica, int a) {
		int aux = 0;
		if (a < 4) {
			if (Caracteristica.toUpperCase() == "FUERZA") {
				aux = gana(this.getFuerza(), u2.getFuerza());
				if (aux != 0)
					return aux;
				return enfrentar(u2, "RESISTENCIA", a+1);
			}
 
			if (Caracteristica.toUpperCase() == "RESISTENCIA") {
				aux = gana(this.getResistencia(), u2.getResistencia());
				if (aux != 0)
					return aux;
 
				return enfrentar(u2, "DESTREZA", a+1);
			}
 
			if (Caracteristica.toUpperCase() == "DESTREZA") {
				aux = gana(this.getDestreza(), u2.getDestreza());
				if (aux != 0)
					return aux;
 
				return enfrentar(u2, "VELOCIDAD", a+1);
			}
			if (Caracteristica.toUpperCase() == "VELOCIDAD") {
				aux = gana(this.getVelocidad(), u2.getVelocidad());
				if (aux != 0)
					return aux;
				return enfrentar(u2, "FUERZA", a+1);
			}
			
			System.out.println("Caracteristica incompatible");
		}
		return 0;
 
	}
	
}
