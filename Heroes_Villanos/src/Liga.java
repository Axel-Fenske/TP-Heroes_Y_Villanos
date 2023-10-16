import java.util.ArrayList;
public abstract class Liga extends Competidor{
	String nombreLiga;

	
	Liga(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		super(heroe_o_villano, nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		// TODO Auto-generated constructor stub
	}
	
	Liga(String nombreLiga, String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.nombreLiga=nombreLiga;
		super(heroe_o_villano, nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		// TODO Auto-generated constructor stub
	}


	ArrayList<Competidor> liga= new ArrayList<Competidor> ();

	
	public double promedioFuerza() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getFuerza();
		}
		
		return prom/liga.size();
	}
	public double promedioVelocidad() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getVelocidad();
		}
		
		return prom/liga.size();
	}

	public double promedioResistencia() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getResistencia();
		}
		
		return prom/liga.size();
	}
	public double promedioDestreza() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getDestreza();
		}
		
		return prom/liga.size();
	}
}
