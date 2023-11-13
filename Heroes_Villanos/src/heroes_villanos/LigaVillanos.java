package heroes_villanos;
public class LigaVillanos extends Liga {

	public LigaVillanos(String nombreLiga) {

		super("villano", nombreLiga);
	}

	public boolean agregar(Competidor villano) {
		if (villano.getTipo().toUpperCase().compareTo("VILLANO") != 0) {
			System.out.println("No se puede insertar heroe en una liga de villanos");
			return false;
		}

		if (villano instanceof Liga) {
			Liga l = (Liga) villano;
			if (l.liga.size() == 0) {
				System.out.println("no puedo insertar una liga vacia?");
				return false;
			}
			if (Liga.extisteEnEstaLiga(this, villano)) {
				System.out.println("un villano ya pertenece a la liga");
				return false;
			}
		}
		super.liga.add(villano);
		return true;
	}

	public void eliminarVillano(Unidad v) {
		if(!Liga.extisteEnEstaLiga(this, v))
			System.out.println("no existe");
		if (super.eliminar(v))
			System.out.println("eliminado: " + v.getNombre());
		else {
			System.out.println("no se pudo eliminar");
		}
	}

}
