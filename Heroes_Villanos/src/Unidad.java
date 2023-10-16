
public class Unidad extends Competidor{


//	private String tipo;
	

	public Unidad(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
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

	public boolean esGanador(Unidad u2, String caracteristica) {
		if (this == u2)
			throw new RuntimeException("no se puede pelear con si mismo");
		int aux = enfrentar(u2, caracteristica, 0);
		if (aux > 0)
			return true;

		return false;

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
