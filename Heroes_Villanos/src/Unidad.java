import javax.management.RuntimeErrorException;

public class Unidad extends Bando{


	private String nombreReal;
	
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;
	private void confirmarTipo(String t) {
		String tipo=t.toLowerCase();
		if(tipo.compareTo("villano")!=0&&tipo.compareTo("heroe")!=0)
			throw new RuntimeException("el tipo debe ser heroe o villano");
		this.tipo=tipo;
	}
	public Unidad(String tipo, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
			int resistencia, int destreza) {
			confirmarTipo(tipo);
			this.nombreReal = nombreReal;
			this.nombre = nombrePersonaje;
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
				+nombre
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
