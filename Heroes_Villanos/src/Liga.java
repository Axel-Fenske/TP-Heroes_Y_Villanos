import java.util.ArrayList;


public class Liga {
	
	String nombreLiga;
	ArrayList<Competidor> liga;
	
	Liga(String nombreLiga) {
		this.nombreLiga=nombreLiga;
		liga=new ArrayList<Competidor>();
	}


	
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
