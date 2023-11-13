
import java.util.Comparator;

public class CompetidorComparador implements Comparator<Competidor>{

	private Caracteristica car;
	
	public CompetidorComparador(Caracteristica car) {
		this.car = car;
	}
	
	@Override
	public int compare(Competidor o1, Competidor o2) {
		return (int)o1.compareTo(o2, car);
	}

}
