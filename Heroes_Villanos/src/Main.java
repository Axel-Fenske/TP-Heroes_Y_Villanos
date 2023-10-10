
public class Main {

	public static void main(String[] args) {
		
		Heroe h1= new Heroe("Spider-Man",700,400,300,200);
		Villano v1=new Villano("Venom",600,400,300,200);
		
		
		Unidad ganador=(Unidad) h1.enfrentar(v1);
		
		
		System.out.println("El ganador es "+ganador.getNombre());
	}

}
