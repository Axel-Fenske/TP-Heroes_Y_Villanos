
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

	

	public boolean esGanador(Competidor u2, String caracteristica) {
		if (this == u2)
			new RuntimeException("no se puede pelear con si mismo");
		int aux = enfrentar2(u2, caracteristica, 0);
		if (aux > 0)
			return true;
 
		return false;
 
	}
 
	private int gana(int a, int b) {
		return a - b;
	}
 
	private  int enfrentar2(Competidor u2, String Caracteristica, int a) {
		int aux = 0;
		if (a < 4) {
			if (Caracteristica.toUpperCase() == "FUERZA") {
				aux = gana(this.fuerza, u2.fuerza);
				if (aux != 0)
					return aux;
				return enfrentar2(u2, "RESISTENCIA", a+1);
			}
 
			if (Caracteristica.toUpperCase() == "RESISTENCIA") {
				aux = gana(this.resistencia, u2.resistencia);
				if (aux != 0)
					return aux;
 
				return enfrentar2(u2, "DESTREZA", a+1);
			}
 
			if (Caracteristica.toUpperCase() == "DESTREZA") {
				aux = gana(this.destreza, u2.destreza);
				if (aux != 0)
					return aux;
 
				return enfrentar2(u2, "VELOCIDAD", a+1);
			}
			if (Caracteristica.toUpperCase() == "VELOCIDAD") {
				aux = gana(this.velocidad, u2.velocidad);
				if (aux != 0)
					return aux;
				return enfrentar2(u2, "FUERZA", a+1);
			}
			
			System.out.println("Caracteristica incompatible");
		}
		return 0;
 
	}



	@Override
	public String toString() {
		return "Es un: "
				+heroe_o_villano
				+"\nSu Nombre Real es: "
				+nombreReal
				+"\nSu Nombre del Personaje es: "
				+nombrePersonaje
				+"\nSu Velocidad es: "
				+velocidad
				+"\nSu Fuerza es: "
				+fuerza
				+"\nSu Resistencia es: "
				+resistencia
				+"\nSu Destreza es: "
				+destreza;
	}
	
	


	
}

