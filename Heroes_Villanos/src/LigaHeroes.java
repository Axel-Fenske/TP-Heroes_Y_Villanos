
public class LigaHeroes extends Liga{


	LigaHeroes(String heroe_o_villano, String nombreReal, String nombrePersonaje, int velocidad, int fuerza,
			int resistencia, int destreza) {
		super(heroe_o_villano, nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		// TODO Auto-generated constructor stub
	}
	public void agregarHeroes(String tipo, String nombreReal, String nombre, int velocidad, int fuerza,int resistencia, int destreza){
		Unidad heroe= new Unidad(tipo,nombreReal,nombre,velocidad,fuerza,resistencia,destreza);
		super.liga.add(heroe);
	}
	public void eliminarHeroes(Unidad v) {
		super.liga.remove(v);
	}

}
