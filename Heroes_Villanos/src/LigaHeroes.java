public class LigaHeroes extends Liga {

	public LigaHeroes(String nombreLiga) {
		super("heroe", nombreLiga);
	}

	public boolean agregar(Competidor heroe) {
		if (heroe.getTipo().toUpperCase().compareTo("HEROE")!=0) {
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

	public void eliminarHeroe(Unidad h) {
		if(!Liga.extisteEnEstaLiga(this, h))
			System.out.println("no existe");
		if (super.eliminar(h))
			System.out.println("eliminado: " + h.getNombre());
		else {
			System.out.println("no se pudo eliminar");
		}
	}

}
