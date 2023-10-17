public class LigaHeroes extends Liga {

	LigaHeroes(String nombreLiga) {
		super("heroe", nombreLiga);
	}

	public boolean agregar(Bando villano) {
		if (villano.getTipo().toUpperCase() != "HEROE") {
			System.out.println("No se puede insertar villano en una liga de heroes");
			return false;
		}
		super.liga.add(villano);
		return true;
	}

	public void eliminarHeroes(Unidad v) {
		super.liga.remove(v);
	}

}
