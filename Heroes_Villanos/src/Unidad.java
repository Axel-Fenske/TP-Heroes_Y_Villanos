
public class Competidor extends Bando{

	private String tipo;
	private String nombreReal;
	private String nombrePersonaje;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

//	private String tipo;
	

	public Competidor(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
			int resistencia, int destreza) {
			this.tipo = heroe_o_villano;
			this.nombreReal = nombreReal;
			this.nombrePersonaje = nombrePersonaje;
			this.velocidad = velocidad;
			this.fuerza = fuerza;
			this.resistencia = resistencia;
			this.destreza = destreza;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public int getDestreza() {
		return destreza;
	}

	public int getFuerza() {
		return fuerza;
	}




	@Override
	public String toString() {
		return "Es un: "
				+tipo
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
