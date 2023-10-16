import java.util.ArrayList;
public abstract class Liga extends Competidor{

	String nombreLiga;

	

	

	ArrayList<Unidad> liga= new ArrayList<Unidad> ();

	
	public double promedioFuerza() {
		double prom=0;
		
		for (Unidad unidad : liga) {
			prom+=unidad.getFuerza();
		}
		
		return prom/liga.size();
	}
	public double promedioVelocidad() {
		double prom=0;
		
		for (Unidad unidad : liga) {
			prom+=unidad.getVelocidad();
		}
		
		return prom/liga.size();
	}

	public double promedioResistencia() {
		double prom=0;
		
		for (Unidad unidad : liga) {
			prom+=unidad.getResistencia();
		}
		
		return prom/liga.size();
	}
	public double promedioDestreza() {
		double prom=0;
		
		for (Unidad unidad : liga) {
			prom+=unidad.getDestreza();
		}
		
		return prom/liga.size();
	}
}
