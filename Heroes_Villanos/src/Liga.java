import java.util.ArrayList;


public class Liga extends Bando {
	
	String nombreLiga;
	ArrayList<Competidor> liga;
	
	
	Liga(String nombreLiga) {
		this.nombreLiga=nombreLiga;
		liga=new ArrayList<Competidor>();
	}

	
	

	
	public double getFuerza() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getFuerza();
		}
		
		return prom/liga.size();
	}
	
	public double getVelocidad() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getVelocidad();
		}
		
		return prom/liga.size();
	}

	public double getResistencia() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getResistencia();
		}
		
		return prom/liga.size();
	}
	
	public double getDestreza() {
		double prom=0;
		
		for (Competidor unidad : liga) {
			prom+=unidad.getDestreza();
		}
		
		return prom/liga.size();
	}

	
	
}
