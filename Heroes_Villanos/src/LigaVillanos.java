import java.util.Iterator;

public class LigaVillanos extends Liga{


	LigaVillanos(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
			int resistencia, int destreza) {
		super(heroe_o_villano, nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		// TODO Auto-generated constructor stub
	}
	public void agregarVillano(String tipo, String nombreReal, String nombre, int velocidad, int fuerza,int resistencia, int destreza){
		Unidad villano= new Unidad(tipo,nombreReal,nombre,velocidad,fuerza,resistencia,destreza);
		super.liga.add(villano);
	}
	public void eliminarVillano(Unidad v) {
		super.liga.remove(v);
	}
	
	
}
