public class LigaHeroes extends Liga {

	LigaHeroes(String nombreLiga) {
		super("heroe", nombreLiga);
	}

	public boolean agregar(Bando heroe) {
		if (heroe.getTipo().toUpperCase() != "HEROE") {
			System.out.println("No se puede insertar villano en una liga de heroes");
			return false;
		}
		if(Liga.extisteEnEstaLiga(this, heroe)) {
			System.out.println("el heroe ya pertenece a la liga");
			return false;
		}
		super.liga.add(heroe);
		return true;
	}

	public void eliminarHeroes(Unidad v) {
		super.liga.remove(v);
	}

}
