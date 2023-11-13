package heroes_villanos;

import java.util.Comparator;

public class CompetidorComparador implements Comparator<Competidor>{

	private Caracteristica car;
	
	public CompetidorComparador(Caracteristica car) {
		this.car = car;
	}
	
	@Override
	public int compare(Competidor o1, Competidor o2) {
		return (int)o2.compareTo(o1, car);
	}

}
